
package WEB_Scenario;

import com.tyss.optimize.common.util.CommonConstants;
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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component("LIC1710_PJT1013_PE_NLPa6616d07-7142-4345-b394-5e577b9512a5")
public class WEB_VerifyNumberOfBanners implements Nlp {
    @InputParams({@InputParam(name = "swiperBullet", type = "org.openqa.selenium.WebElement"), @InputParam(name = "bannerImage", type = "org.openqa.selenium.WebElement"),
    	@InputParam(name = "firstProduct", type = "org.openqa.selenium.WebElement"),@InputParam(name = "pantaloonsLogo", type = "org.openqa.selenium.WebElement"),
    	@InputParam(name = "myAccount", type = "org.openqa.selenium.WebElement"),@InputParam(name = "Banners", type = "org.openqa.selenium.WebElement")
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
      @Override
      public NlpResponseModel execute(NlpRequestModel nlpRequestModel) throws NlpException {
        
          NlpResponseModel nlpResponseModel = new NlpResponseModel();
          Map<String, Object> attributes = nlpRequestModel.getAttributes();
          String swiperBullet = (String) attributes.get("swiperBullet");
          String bannerImage = (String) attributes.get("bannerImage");
          String firstProduct = (String) attributes.get("firstProduct");
          String pantaloonsLogo = (String) attributes.get("pantaloonsLogo");
          String myAccount = (String) attributes.get("myAccount");
          String Banners = (String) attributes.get("Banners");

          try {
        	  
        	  WebDriver driver = nlpRequestModel.getWebDriver();
        	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        	  List<WebElement> banners=driver.findElements(By.xpath(Banners));
              int numberofbanners=banners.size();
             
              for(int i=1;i<=numberofbanners;i++){
                  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(swiperBullet)));
                  driver.findElement(By.xpath(swiperBullet+"["+i+"]")).click();
                  driver.findElement(By.xpath(bannerImage+"["+i+"]")).click();
                  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(firstProduct)));
                  driver.findElement(By.xpath(pantaloonsLogo)).click();
                  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(myAccount)));
                  
                  
        	  
          }
              nlpResponseModel.setStatus(CommonConstants.pass);
     		 nlpResponseModel.setMessage("Total number of banners is "+numberofbanners+" and navigated to particular page");
          }
          catch(Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.fail);
      		 nlpResponseModel.setMessage("Failed to fetch total number of banners ");
          }

          
          return nlpResponseModel;
      }
  } 