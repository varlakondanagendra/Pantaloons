package Mob_Scenario;

import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;
import java.util.Map;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.TouchAction;
import org.springframework.stereotype.Component;
import com.tyss.optimize.nlp.util.*;
import com.tyss.optimize.common.util.CommonConstants;
import java.util.Set;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



@Component("LIC1710_PJT1013_PE_NLP275c9502-d8b5-4b19-9e75-54ff40e69acd")
public class MOB_RemovingProducts  implements Nlp {
  //  @InputParams({@InputParam(name = "waitTime", type = "java.lang.String")})
    
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
        //String waitTime = (String) attributes.get("locatorValue");
        DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability("waitForIdleTimeout", 0);
        try {
        AndroidDriver driver= nlpRequestModel.getAndroidDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.view.ViewGroup[@index=\"5\"])[1]")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//android.view.ViewGroup[@index=\"5\"])[1]")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@text,\"MY BAG\")]")));
		Thread.sleep(3000);
		List items = driver.findElements(By.xpath("//android.widget.ImageView/../../../following-sibling::android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView"));
        int count=items.size();
        if(count>0) {
        try {
        while(count>0) {
		if(driver.findElement(By.xpath("(//android.widget.ImageView/../../../following-sibling::android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView)[1]")).isDisplayed()) {
			Thread.sleep(1000);
        	driver.findElement(By.xpath("(//android.widget.ImageView/../../../following-sibling::android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView)[1]")).click();
        	driver.findElement(By.xpath("//android.widget.TextView[@text=\"REMOVE\"]")).click();
        	Thread.sleep(3000);
        }
        
		else {
			break;
		}
        }
        
        }catch(Exception e) {
        	driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        	nlpResponseModel.setStatus(CommonConstants.pass);
            nlpResponseModel.setMessage("Products are Removed From My Bag");
        	
        }
        }else {
        	driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        	nlpResponseModel.setStatus(CommonConstants.pass);
            nlpResponseModel.setMessage("No Products in My Bag");
        	
        }  
        
        } catch(Exception e) {
                  nlpResponseModel.setStatus(CommonConstants.fail);
			      nlpResponseModel.setMessage("Failed to Remove Products From My Bag");
        }
        return nlpResponseModel;
    }
} 

