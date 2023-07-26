
package Mob_web_Scenario;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import java.util.Map;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.springframework.stereotype.Component;

@Component("LIC1710_PJT1013_PE_NLP99721d27-89f1-413e-a8e8-47cac0530687")
public class Wait_Till_Page_To_Load implements Nlp {
    @InputParams({@InputParam(name = "Implicit time", type = "java.lang.String")})
    

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
          String Implicittime = (String) attributes.get("Implicit time");
          WebDriver driver =null;
          // Your program element business logic goes here ...
          try {
        	  driver = nlpRequestModel.getWebDriver();
        	  
              WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Long.parseLong(Implicittime)));
              boolean pageLoaded = waitUntilPageLoaded(driver);
             if (pageLoaded) {
                  nlpResponseModel.setStatus(CommonConstants.pass);
                  nlpResponseModel.setMessage("Page loaded successfully.");
              } else {
            	  nlpResponseModel.setStatus(CommonConstants.fail);
                  nlpResponseModel.setMessage("Page not loaded completely.");
              }
  	  
          }catch(Exception e){
        	  nlpResponseModel.setStatus(CommonConstants.fail);
              nlpResponseModel.setMessage("Failed to execute NLP");
          }
         
          return nlpResponseModel;
      }
      
     
	public static boolean waitUntilPageLoaded(WebDriver driver) {
          JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

          return (boolean) jsExecutor.executeScript("return document.readyState").equals("complete");
      }
  } 