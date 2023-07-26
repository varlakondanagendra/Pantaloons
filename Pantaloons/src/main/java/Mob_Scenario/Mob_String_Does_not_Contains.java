package Mob_Scenario;



import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;


@Component("LIC1710_PJT1013_PE_NLPfdf1a8df-bd43-481e-998d-b819b82d52de")
public class Mob_String_Does_not_Contains implements Nlp {
    @InputParams({@InputParam(name = "string1", type = "java.lang.String"), @InputParam(name = "string2", type = "java.lang.String")})
   // @ReturnType(name = "string3", type = "java.lang.String")

      @Override
    public List<String> getTestParameters() throws NlpException {
      List<String> params = new ArrayList<>();
      return params;
  }
  
   @Override
  public StringBuilder getTestCode() throws NlpException {
      StringBuilder sb = new StringBuilder();
      return sb;
  }
    @Override
    public NlpResponseModel execute(NlpRequestModel nlpRequestModel) throws NlpException {
  	 
        NlpResponseModel nlpResponseModel = new NlpResponseModel();
        Map<String, Object> attributes = nlpRequestModel.getAttributes();
        String string1 = (String) attributes.get("string1");
        String string2 = (String) attributes.get("string2");
        try {
      	  if(!string1.contains(string2)) {
      		  
        		nlpResponseModel.setMessage(string1 +" does not Contains "+ string2);
        		nlpResponseModel.setStatus(CommonConstants.pass);
        	}
        	else {
        		nlpResponseModel.setMessage(string1 +" Contains "+ string2);
        		nlpResponseModel.setStatus(CommonConstants.fail);
        	}
		} catch (Exception e) {
			nlpResponseModel.setMessage("Failed to compare");
    		nlpResponseModel.setStatus(CommonConstants.fail);
		}
    	
        return nlpResponseModel;
    }
} 
