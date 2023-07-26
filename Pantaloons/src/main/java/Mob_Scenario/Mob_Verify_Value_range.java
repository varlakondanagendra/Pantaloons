
  package Mob_Scenario;

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

  @Component("LIC1710_PJT1013_PE_NLPe2e7f0ea-5e37-4571-bfed-917cb6db1149")
  public class Mob_Verify_Value_range implements Nlp {
	  Integer Value=0;

      @InputParams({@InputParam(name = "value", type = "java.lang.String"),@InputParam(name = "Intial Value", type = "java.lang.Integer"),
    	  @InputParam(name = "Final Value", type = "java.lang.Integer")})
     // @ReturnType(name = "Final Value", type = "java.lang.Integer")

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
          String value = (String) attributes.get("value");
          Integer Intial_Value = (Integer) attributes.get("Intial Value");
          Integer Final_Value = (Integer) attributes.get("Final Value");
try {
	
	
	String v= value.replaceAll("[^0-9?]", "");
	Value=Integer.parseInt(v);
	
	if(Value>=Intial_Value) {
		if(Value<=Final_Value) {
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage(Value+" is within the given range");
		}
		else {
			nlpResponseModel.setMessage(Value+" is not within the given range");
			nlpResponseModel.setStatus(CommonConstants.fail);
		}
		
	}
	else {
		nlpResponseModel.setMessage(Value+" is not within the range");
		nlpResponseModel.setStatus(CommonConstants.fail);
	}

}catch(Exception r){
	nlpResponseModel.setMessage("Failed to Compare");
	nlpResponseModel.setStatus(CommonConstants.fail);
}
          
          return nlpResponseModel;
      }
  } 