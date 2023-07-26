
package WEB_Scenario;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component("LIC1710_PJT1013_PE_NLP32e5c044-48cd-4bcd-9e47-b34ec3179632")
public class WEB_ValidateBannersInHomePage implements Nlp {
    @InputParams({@InputParam(name = "bannersCarousel", type = "java.lang.String"), 
    @InputParam(name = "bannersImage", type = "java.lang.String"),
    @InputParam(name = "productLocator", type = "java.lang.String"),
    })
   

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
      
      public static  boolean retryingFindClick(String xpath,WebDriver driver) {
  	    boolean result = false;
  	    int attempts = 0;
  	    while(attempts < 2) {
  	        try {
  	            driver.findElement(By.xpath(xpath)).click();
  	            result = true;
  	            break;
  	        } catch(StaleElementReferenceException e) {
  	        }
  	        attempts++;
  	    }
  	    return result;
  	}
      
      @Override
      public NlpResponseModel execute(NlpRequestModel nlpRequestModel) throws NlpException {
        
          NlpResponseModel nlpResponseModel = new NlpResponseModel();
          Map<String, Object> attributes = nlpRequestModel.getAttributes();
          String bannersCarousel = (String) attributes.get("bannersCarousel");
          String bannersImage = (String) attributes.get("bannersImage");
          String productLocator = (String) attributes.get("productLocator");

          try {
        	    WebDriver driver = nlpRequestModel.getWebDriver();
        		List<WebElement> bannersLocator = driver.findElements(By.xpath(bannersCarousel));
        		int bannerSize = bannersLocator.size();
        		int bannersSize=bannerSize;
        		for(int i=bannersSize;i<=bannersSize;i--) {
        	    driver.findElement(By.xpath(bannersCarousel+"["+bannersSize+"]")).click();
        		Thread.sleep(1000);
        	    retryingFindClick(bannersImage+"["+bannersSize+"]", driver);
        	    driver.findElement(By.xpath(productLocator)).isDisplayed();
        	    driver.navigate().back();
        	    bannersSize--;
        	    if(bannersSize==0) {
        		      break;
        			}
          }
              nlpResponseModel.setStatus(CommonConstants.pass);
     		 nlpResponseModel.setMessage("Total number of banners is "+bannerSize+" and navigated to particular page");
          }
          catch(Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.fail);
      		 nlpResponseModel.setMessage("Failed to Fetch Total number of banners" +e);
          } 
          return nlpResponseModel;
      }
  } 