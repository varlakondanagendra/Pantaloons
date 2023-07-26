package Mob_Scenario;
import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.util.Map;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("LIC1710_PJT1013_PE_NLPa3ba3a70-7ded-4c29-aa70-ddb90ca8699f")
public class MOB_ClosePreviousAppliaction implements Nlp {

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
        
        try {
        	AndroidDriver driver=(AndroidDriver) nlpRequestModel.getDriver().getSpecificIDriver();
        	driver.pressKey(new KeyEvent().withKey(AndroidKey.APP_SWITCH));
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//android.widget.Button[@text='Close all']")).click();
        	nlpResponseModel.setMessage(CommonConstants.pass);
        	nlpResponseModel.setStatus("Recent Application closed successfully");
        	
		} catch (Exception e) {
    		nlpResponseModel.setStatus(CommonConstants.fail);
    		nlpResponseModel.setMessage("Failed to close Recent Application"+e);
		}
    	
        return nlpResponseModel;
    }
} 
