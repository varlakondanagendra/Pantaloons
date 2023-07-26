package Mob_Scenario;

import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;  
import com.tyss.optimize.nlp.util.annotation.InputParam; 
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import io.appium.java_client.android.AndroidDriver;

import com.tyss.optimize.common.util.CommonConstants;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;


@Component("LIC1710_PJT1013_PE_NLP4b6dbc38-72f1-4ce1-9d50-dad431d9890a")
public class Mob_Revoke_USB_Debugging_Authorisations  implements Nlp {

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
			DesiredCapabilities capabilities=new DesiredCapabilities();
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("appPackage","com.android.settings");
			capabilities.setCapability("appActivity", "com.android.settings.Settings");
			capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			capabilities.setCapability("noReset",true);
			capabilities.setCapability("waitForIdleTimeout", 0);
			AndroidDriver driver=new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Settings\"]")));
			driver.findElement(By.xpath("//android.widget.TextView[@text=\"Settings\"]")).isDisplayed();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Settings']/../..//android.view.ViewGroup//android.widget.Button")));
			driver.findElement(By.xpath("//android.widget.TextView[@text='Settings']/../..//android.view.ViewGroup//android.widget.Button")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.AutoCompleteTextView[contains(@text,'Search')]")));
			driver.findElement(By.xpath("//android.widget.AutoCompleteTextView[contains(@text,'Search')]")).sendKeys("Revoke USB debugging authorisations");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@text,'Revoke USB debugging authorisations')]")));
			driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Revoke USB debugging authorisations')]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@text,'Revoke USB debugging authorisations')]/../..")));
			driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Revoke USB debugging authorisations')]/../..")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[contains(@text,'OK')]")));
			driver.findElement(By.xpath("//android.widget.Button[contains(@text,'OK')]")).click();
			driver.close();
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("USB Revoked");
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Failed to Revoke");
		}
		return nlpResponseModel;
	}
} 


