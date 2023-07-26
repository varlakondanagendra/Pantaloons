 package WEB_Scenario;
  import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams; 
  
 


@Component("LIC1710_PJT1013_PE_NLP26e47b5f-0a3a-43ae-8f2a-1d8e7c63865c")
  public class WEB_Wait_until_Element_is_visible implements Nlp {
      @InputParams({@InputParam(name = "waittime", type = "java.lang.String"), @InputParam(name = "locatorValue", type = "java.lang.String")})
      

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
          String waittime = (String) attributes.get("waittime");
          String locatorValue = (String) attributes.get("locatorValue");
          
         
        
	   try {
		   WebDriver driver = nlpRequestModel.getWebDriver();
              		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Long.parseLong(waittime)));
		            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));	
	                nlpResponseModel.setStatus(CommonConstants.pass);
	                nlpResponseModel.setMessage("Successfully waited until element is visible in UI");
          }
          catch(Exception e) {
              nlpResponseModel.setStatus(CommonConstants.fail);
	          nlpResponseModel.setMessage("Failed to wait until element is visible in UI");
          }
          
          return nlpResponseModel;
      }
  } 