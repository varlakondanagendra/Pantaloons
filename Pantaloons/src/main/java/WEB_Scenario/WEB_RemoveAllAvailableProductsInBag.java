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

@Component("LIC1710_PJT1013_PE_NLP67ae81ce-5189-4a2d-95a6-b6bb94c52e29")
public class WEB_RemoveAllAvailableProductsInBag implements Nlp {
	
    @InputParams({@InputParam(name = "availableProducts", type = "java.lang.String"),
    	@InputParam(name = "deleteIcon", type = "java.lang.String"),
    	@InputParam(name = "removeIcon", type = "java.lang.String"),
    	@InputParam(name = "waitTime", type = "java.lang.Integer")})
    @ReturnType(name = "isDisplayed", type = "java.lang.Boolean")

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
         
          boolean isDisplayed=false;
          try {
        	  String availableProducts = (String) attributes.get("availableProducts");
              String deleteIcon = (String) attributes.get("deleteIcon");
              String removeIcon = (String) attributes.get("removeIcon");
              Integer waitTime=(Integer) attributes.get("waitTime");
             boolean isEnabled=false;
              isDisplayed=false;
        	  WebDriver driver=(WebDriver)nlpRequestModel.getDriver().getSpecificIDriver();
        	  List<WebElement> list=driver.findElements(By.xpath(availableProducts));
        	 for(WebElement text:list) {
        		 WebElement productlist=driver.findElement(By.xpath(availableProducts));
        		 isDisplayed=productlist.isDisplayed();
        		 if(isDisplayed==true) {
        		 WebElement delete=driver.findElement(By.xpath(deleteIcon));
    			 WebDriverWait wait=(WebDriverWait) new WebDriverWait(driver, Duration.ofSeconds(waitTime)).until(ExpectedConditions.elementToBeClickable(delete));
        		 isEnabled= delete.isEnabled();
        		 if(isEnabled==true) {
        			 delete.click();
        			 WebDriverWait waitTill=(WebDriverWait) new WebDriverWait(driver, Duration.ofSeconds(waitTime)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(removeIcon))));
        			 driver.findElement(By.xpath(removeIcon)).click();
        		 }
        		 else {
        			 nlpResponseModel.setMessage(CommonConstants.pass);
        			 nlpResponseModel.setStatus("No such products available in My bag");
        		 }
        	 }
        		 else {
        			 nlpResponseModel.setMessage(CommonConstants.pass);
        			 nlpResponseModel.setStatus("No such products available in My bag");
        		 }
          }
        	 nlpResponseModel.setMessage(CommonConstants.pass);
        	 nlpResponseModel.setStatus("Successfully Deleted all the products in My bag");
          }catch(Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.fail);
 			 nlpResponseModel.setMessage("Fail to delete All the Products in My bag"+e);
          }

         
          nlpResponseModel.getAttributes().put("isDisplayed", isDisplayed);
          return nlpResponseModel;
      }
  } 