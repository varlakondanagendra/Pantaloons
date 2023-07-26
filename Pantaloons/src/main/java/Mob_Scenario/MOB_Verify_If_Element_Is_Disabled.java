
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

import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;


@Component("LIC1710_PJT1013_PE_NLPf984d05c-3060-4bd9-91e5-f7d2e6da2665")
public class MOB_Verify_If_Element_Is_Disabled implements Nlp {
    @InputParams({@InputParam(name = "Element", type = "org.openqa.selenium.WebElement")})
    @ReturnType(name = "isDisabled", type = "java.lang.Boolean")

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
          WebElement element = (WebElement) attributes.get("Element");
          Boolean isDisabled=false;
          try {
        	  isDisabled =!element.isEnabled();
			nlpResponseModel.setMessage("Element is Disabled");
			nlpResponseModel.setStatus(CommonConstants.pass);
			}
			catch (Exception e) {
			nlpResponseModel.setMessage("Element is not Disabled"+e);
			nlpResponseModel.setStatus(CommonConstants.fail);
		}
      
          nlpResponseModel.getAttributes().put("isDisabled", isDisabled);
          return nlpResponseModel;
      }
  } 