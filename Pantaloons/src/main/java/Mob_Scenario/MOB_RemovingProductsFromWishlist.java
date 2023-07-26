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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Component("LIC1710_PJT1013_PE_NLP1badd092-4a3c-4e4d-a9db-6913b8fed670")
public class MOB_RemovingProductsFromWishlist  implements Nlp {
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
        
        AndroidDriver driver= nlpRequestModel.getAndroidDriver();
        // Your program element business logic goes here ...
        try {
        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
    		wait.until(ExpectedConditions
    				.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@text,'Welcome')]")));
    		driver.findElement(
    				By.xpath("(//android.widget.ImageView[@index=0])[5]"))
    				.click();

    		// driver.quit();
    		//WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(200));

    		List<WebElement> element = driver.findElements(By.xpath(
    				"//android.widget.TextView[@text='MOVE TO BAG']/..//android.view.ViewGroup[@index='2']//android.widget.ImageView"));

    		int a = element.size();
    		if (a > 0) {
    			while (a > 0) {
    				
    				List<WebElement> elementss = driver.findElements(By.xpath(
    						"//android.widget.TextView[@text='MOVE TO BAG']/..//android.view.ViewGroup[@index='2']//android.widget.ImageView"));
    				a=elementss.size();
    				wait.until(ExpectedConditions.visibilityOf(
    						driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'WISHLIST')]"))));
    				Thread.sleep(2000);

    				WebElement delete1 = driver.findElement(By.xpath("(//android.widget.TextView[@text='MOVE TO BAG']/..//android.view.ViewGroup[@index='2']//android.widget.ImageView)[1]"));

    				Thread.sleep(2000);

    				delete1.click();

    				Thread.sleep(2000);
    				
    				a--;

    			}
    		}

    		driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
    		
    		nlpResponseModel.setStatus(CommonConstants.pass);
            nlpResponseModel.setMessage("Products are removed from Wishlist");    
            
              
        } catch(Exception e) {
                  nlpResponseModel.setStatus(CommonConstants.fail);
			      nlpResponseModel.setMessage("Failed to remove Products from Wishlist");
        }
        return nlpResponseModel;
    }
} 

