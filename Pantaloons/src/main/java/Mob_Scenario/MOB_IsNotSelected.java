
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

@Component("LIC1710_PJT1013_PE_NLP0d8b2306-59b8-40ed-b463-14b7a8ffb625")
public class MOB_IsNotSelected implements Nlp {
    @InputParams({@InputParam(name = "element", type = "org.openqa.selenium.WebElement"),
    	@InputParam(name = "elementName", type = "java.lang.String"),
    	@InputParam(name = "elementType", type = "java.lang.String")})
    @ReturnType(name = "isNotSelected", type = "java.lang.Boolean")

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
          WebElement element = (WebElement) attributes.get("element");
          Boolean notSelected=null;
          try {
			notSelected =!element.isSelected();
			nlpResponseModel.setMessage("Element is not Selected");
			nlpResponseModel.setStatus(CommonConstants.pass);
		} catch (Exception e) {
			nlpResponseModel.setMessage("Element is Selected"+e);
			nlpResponseModel.setStatus(CommonConstants.fail);
		}
          nlpResponseModel.getAttributes().put("isNotSelected", notSelected);
          return nlpResponseModel;
      }
  } 