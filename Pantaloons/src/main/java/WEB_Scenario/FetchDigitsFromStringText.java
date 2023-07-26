package WEB_Scenario;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component("LIC1710_PJT1013_PE_NLP44f98f98-33e6-4800-94aa-aa0494167fe3")
public class FetchDigitsFromStringText implements Nlp {
	 @InputParams({	@InputParam(name = "StringText", type = "java.lang.String")})
     @ReturnType(name = "Number", type = "java.lang.Integer")

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
          String StringText = (String) attributes.get("StringText");
          int Number = 0;
          try {
        	   	String bag= StringText.replaceAll("[?]", "");
        	    String bag1= bag.replace(" ",""); 
        	    Number=Integer.parseInt(bag1);
        	
        	  
        	  nlpResponseModel.setStatus(CommonConstants.pass);
        	  nlpResponseModel.setMessage("The Fetched Integer Value is: "+Number);
          }
         catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to fetch the integer value");
		}
          nlpResponseModel.getAttributes().put("Number", Number);
          return nlpResponseModel;
      }
  } 