package Mob_Scenario;




import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import io.appium.java_client.android.AndroidDriver;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;




@Component("LIC1710_PJT1013_PE_NLP58c0c686-ab25-49de-9a78-ceb9202fb6d6")
public class RemoveMultipleProductsFromWishlist implements Nlp {
    @InputParams({@InputParam(name = "Xpath", type = "java.lang.String")})
    

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
          String string1 = (String) attributes.get("Xpath");
        	AndroidDriver driver = nlpRequestModel.getAndroidDriver();
          try {
        	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        	  WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
        	  List<WebElement> removeIcon = driver.findElements(By.xpath(string1));
        	
        	  if(removeIcon.size()>0) {
        		  for(int i=0;i<=removeIcon.size();i++) {
        				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(string1)));
        			    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(string1)));
        			    driver.findElement(By.xpath(string1)).click();
        			    Thread.sleep(3000);
        			    if(i==removeIcon.size())
        			    {
        			    	driver.navigate().refresh();
        			    	if(driver.findElement(By.xpath("//android.widget.TextView[@text='No Wishlisted Items']")).isDisplayed()) {
        			    		break;
        			    	}
        			    	else
        			    	{
        			    		driver.findElement(By.xpath(string1)).click();
        			    	}
        			    	break;
        			    }
        				
        			}
        		  nlpResponseModel.setMessage("Removed " +removeIcon.size()+" Products from the wishlist");
        		  nlpResponseModel.setStatus(CommonConstants.pass);
        			
        	  }
        	  else {
        		  
        		  nlpResponseModel.setMessage("Wishlist is empty");
        		  nlpResponseModel.setStatus(CommonConstants.pass);
        	  }
        	  
        	  
          } catch(Exception e) {
        	  nlpResponseModel.setMessage("failed to remove items in the wishlist"+ e);
        	  nlpResponseModel.setStatus(CommonConstants.fail);
        	  
          }

        
          return nlpResponseModel;
      }
  } 