
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







@Component("LIC1710_PJT1013_PE_NLP7a965202-01da-4aa1-83c4-0705e24f0d43")
public class MOB_Delete_Product implements Nlp {
	@InputParams({ @InputParam(name = "DeleteIcon", type = "java.lang.String"),
		@InputParam(name = "RemoveButton", type = "java.lang.String"),
		@InputParam(name = "DeleteIconElement", type = "org.openqa.selenium.WebElement"),
		@InputParam(name = "RemoveButtonElement", type = "org.openqa.selenium.WebElement")})

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
		WebElement deleWebElement=(WebElement) attributes.get("Element");
		WebElement removeWebElement =(WebElement) attributes.get("Element");
		AndroidDriver driver=null;
		TouchActions touchAction = new TouchActions(driver);
		try {
			driver=nlpRequestModel.getAndroidDriver();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			try {
			if (driver.findElements(AppiumBy.xpath(DeleteIcon)).size() > 0) {
				for (int i = 1; i <= driver.findElements(AppiumBy.xpath(DeleteIcon)).size(); i++) {
					//wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath(DeleteIcon))).click();;
					//touchAction.singleTap(deleWebElement).perform();
					driver.findElement(AppiumBy.xpath(DeleteIcon)).click();
					Thread.sleep(3000);
					//wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath(RemoveButton))).click();;
					//touchAction.singleTap(removeWebElement).perform();
					driver.findElement(AppiumBy.xpath(RemoveButton)).click();
					Thread.sleep(1000);
					nlpResponseModel.setMessage("Product Deleted");
					nlpResponseModel.setStatus(CommonConstants.pass);
				}
			}else {
				if (driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Its empty in here. Let's find you your fashion fix.']")).isDisplayed()) {
					nlpResponseModel.setMessage("Oops sorry no products found");
					nlpResponseModel.setStatus(CommonConstants.pass);
				}
			}
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to delete the product from bag"+e);
		}
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to delete the product from bag"+e);
		}
		return nlpResponseModel;
	}
}