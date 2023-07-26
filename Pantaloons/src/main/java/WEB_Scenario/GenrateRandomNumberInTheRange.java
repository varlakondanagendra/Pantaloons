
package WEB_Scenario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import lombok.extern.slf4j.Slf4j;

@Component("LIC1710_PJT1013_PE_NLP0f02df62-aa09-4855-bfa8-d677d908a9c8")
public class GenrateRandomNumberInTheRange implements Nlp {
    @InputParams({@InputParam(name = "startRange", type = "java.lang.Integer"), @InputParam(name = "endRange", type = "java.lang.Integer")})
    @ReturnType(name = "randomNumber", type = "java.lang.Integer")

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
      	Integer startRange=(Integer) attributes.get("startRange");
    	Integer endRange=(Integer) attributes.get("endRange");
          // Your program element business logic goes here ...
        Integer randomNumber = 0;
try {
	Random random = new Random();

	 randomNumber = (Integer)random.nextInt(startRange, endRange);
	 nlpResponseModel.setStatus(CommonConstants.pass);
		nlpResponseModel.setMessage("Succesfully generated random number "+ randomNumber);
	
}
catch(Exception e)
{
	nlpResponseModel.setStatus(CommonConstants.fail);
		nlpResponseModel.setMessage("Failed to generate random number"+e);
		
	
}
         
          nlpResponseModel.getAttributes().put("randomNumber",randomNumber );
          return nlpResponseModel;
      }
  } 