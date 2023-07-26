 package Mob_Scenario;
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

  import com.tyss.optimize.common.util.CommonConstants;
  import org.openqa.selenium.support.ui.WebDriverWait;
 
  import java.time.Duration;
  import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
  import io.appium.java_client.android.AndroidDriver; 
  
 
  @Component("LIC1710_PJT1013_PE_NLP8b017493-9f0b-4cd4-ad9a-8116d25e4bc7")
public class MOB_Verify_If_Wait_until_Element_is_visible_And_Displayed implements Nlp {
	  @InputParams({@InputParam(name = "Element", type = "org.openqa.selenium.WebElement"),
          @InputParam(name = "Wait", type = "java.lang.String")})

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
          WebElement element=(WebElement) attributes.get("Element");
          
	   try {
		   AndroidDriver driver = nlpRequestModel.getAndroidDriver();
              		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Long.parseLong(waittime)));
		            wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
	                nlpResponseModel.setStatus(CommonConstants.pass);
	                nlpResponseModel.setMessage("Successfully waited until element is visible and Displayed in UI");
          }
          catch(Exception e) {
              nlpResponseModel.setStatus(CommonConstants.fail);
	          nlpResponseModel.setMessage("Failed to wait until element is visible and Displayed in UI");
          }
          
          return nlpResponseModel;
      }
  } 