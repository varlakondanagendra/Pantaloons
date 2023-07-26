 package Mob_Scenario;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
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

import io.appium.java_client.android.AndroidDriver;

@Component("LIC1710_PJT1013_PE_NLPe16673d5-d4c3-47be-ac33-986f0c207445")
public class MOB_WaitUnTillElementIsClickable implements Nlp {
	      @InputParams({@InputParam(name = "elementName", type = "java.lang.String"), 
	      @InputParam(name = "elementType", type = "java.lang.String"), 
	      @InputParam(name = "element", type = "org.openqa.selenium.WebElement"),
	      @InputParam(name = "waitTime", type = "java.lang.String")})
	      

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
          String waitTime = (String) attributes.get("waitTime");
          WebElement element = (WebElement) attributes.get("element");
          
          AndroidDriver driver = nlpRequestModel.getAndroidDriver();
        
	   try {
		   //logic code
		   
		   if(element.isDisplayed() && element.isEnabled()) {
			        Thread.sleep(2000);
		            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Long.parseLong(waitTime)));
		            wait.until(ExpectedConditions.elementToBeClickable(element));
	                nlpResponseModel.setStatus(CommonConstants.pass);
	                nlpResponseModel.setMessage("Successfully Element is Enabled and Clickable");
		   }else {
               nlpResponseModel.setStatus(CommonConstants.pass);
               nlpResponseModel.setMessage("Successfully waited until element is clickable");
		   }
          }
          catch(Exception e) {
              nlpResponseModel.setStatus(CommonConstants.fail);
	          nlpResponseModel.setMessage("Failed to wait until element is clickable ");
          }
          
          return nlpResponseModel;
      }
  } 