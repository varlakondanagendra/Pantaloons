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
  

@Component("LIC1710_PJT1013_PE_NLPe8dcd268-47aa-48d6-8edd-27b53c26c5c2")
  public class WEB_WaitUntillTitleContains implements Nlp {
      @InputParams({@InputParam(name = "WaitTime", type = "java.lang.String"), @InputParam(name = "ExpectedTitle", type = "java.lang.String")})
      

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
          String WaitTime = (String) attributes.get("WaitTime");
          String ExpectedTitle = (String) attributes.get("ExpectedTitle");
          Boolean titleContains=null;
          WebDriver driver = nlpRequestModel.getWebDriver();
         
        
	   try {
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Long.parseLong(WaitTime)));
		 titleContains =wait.until(ExpectedConditions.titleContains(ExpectedTitle));
		 if(titleContains==true) {
	     nlpResponseModel.setStatus(CommonConstants.pass);
	     nlpResponseModel.setMessage("Successfully Title Contains +"+ExpectedTitle);
		   }
          }
          catch(Exception e) {
        	  titleContains=false;
              nlpResponseModel.setStatus(CommonConstants.fail);
	          nlpResponseModel.setMessage("Title Does not contains "+ExpectedTitle);
          }
          
          return nlpResponseModel;
      }
  } 