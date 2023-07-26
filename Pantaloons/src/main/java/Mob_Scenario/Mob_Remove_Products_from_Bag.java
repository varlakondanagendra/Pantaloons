
package Mob_Scenario;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
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

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;







@Component("LIC1710_PJT1013_PE_NLPbfd69979-c6f0-4c75-ac8a-09e30522777a")
public class Mob_Remove_Products_from_Bag implements Nlp {
	@InputParams({ @InputParam(name = "DeleteIcon", type = "java.lang.String"),
		@InputParam(name = "RemoveButton", type = "java.lang.String")})

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
		String DeleteIcon = (String) attributes.get("DeleteIcon");
		String RemoveButton = (String) attributes.get("RemoveButton");
		//WebElement deleWebElement=(WebElement) attributes.get("Element");
		//WebElement removeWebElement =(WebElement) attributes.get("Element");
		AndroidDriver driver=null;
		TouchActions touchAction = new TouchActions(driver);
		
int count=0;
		
		try {
			driver=nlpRequestModel.getAndroidDriver();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			count=driver.findElements(AppiumBy.xpath(DeleteIcon)).size();
			
			List<WebElement> elemets=driver.findElements(AppiumBy.xpath(DeleteIcon));
			
			if(count>0) {
			for(WebElement e:elemets) {
				
				e.click();
				Thread.sleep(3000);
				driver.findElement(AppiumBy.xpath(RemoveButton)).click();
				Thread.sleep(2000);
			}
			nlpResponseModel.setMessage("Removed all items");
			nlpResponseModel.setStatus(CommonConstants.pass);
			}
			
			else {
				
				nlpResponseModel.setMessage("Oops sorry no products found");
				nlpResponseModel.setStatus(CommonConstants.pass);
				
			}	
		}
		catch(Exception e) {
			nlpResponseModel.setMessage("Fialed");
			nlpResponseModel.setStatus(CommonConstants.fail);
			
		}
		return nlpResponseModel;
	}
}