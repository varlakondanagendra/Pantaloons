
  package WEB_Scenario;

  import com.tyss.optimize.nlp.util.Nlp;
  import com.tyss.optimize.nlp.util.NlpException;
  import com.tyss.optimize.nlp.util.NlpRequestModel;
  import com.tyss.optimize.nlp.util.NlpResponseModel;
  import com.tyss.optimize.nlp.util.annotation.InputParam;
  import com.tyss.optimize.nlp.util.annotation.InputParams;
  import com.tyss.optimize.nlp.util.annotation.ReturnType;
  import com.tyss.optimize.common.util.CommonConstants;
import org.springframework.stereotype.Component;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;

  @Component("LIC1710_PJT1013_PE_NLP0e78bf6d-6444-4228-820e-2d6cfdb5c4ea")
  public class WEB_CheckPointForIfCondition implements Nlp {
      @InputParams({@InputParam(name = "Xpath", type = "java.lang.String")})
      @ReturnType(name = "isNotDisplayed", type = "java.lang.Boolean")

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
          String xpath = (String) attributes.get("Xpath");
          WebDriver driver=nlpRequestModel.getWebDriver();
          
          Boolean isNotDisplayed = null;
          try {
        	  isNotDisplayed=driver.findElement(By.xpath(xpath)).isDisplayed();
        	  if(isNotDisplayed==true) {
              nlpResponseModel.setStatus(CommonConstants.pass);
              nlpResponseModel.setMessage("The element is displayed");
        	  }
          }
          catch(NoSuchElementException e) {
              isNotDisplayed = false;
              nlpResponseModel.setStatus(CommonConstants.pass);
              nlpResponseModel.setMessage("The element is not displayed");     
          }
          catch (java.lang.IllegalArgumentException e) {
              isNotDisplayed = false;
              nlpResponseModel.setStatus(CommonConstants.pass);
              nlpResponseModel.setMessage("The Element is not displayed"); 
		}
          catch(Exception e) {
              nlpResponseModel.setStatus(CommonConstants.fail);
              nlpResponseModel.setMessage("Failed to verify the condition");
          }
          nlpResponseModel.getAttributes().put("isNotDisplayed", isNotDisplayed);
          return nlpResponseModel;
      }
  } 