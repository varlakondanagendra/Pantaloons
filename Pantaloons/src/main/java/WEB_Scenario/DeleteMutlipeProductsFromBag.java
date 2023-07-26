
package WEB_Scenario;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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


@Component("LIC1710_PJT1013_PE_NLP799625c1-34d8-448f-9b89-31d80071050b")
public class DeleteMutlipeProductsFromBag implements Nlp {
	@InputParams({ @InputParam(name = "DeleteIcon", type = "java.lang.String"),
		@InputParam(name = "RemoveButton", type = "java.lang.String") })

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
		WebDriver driver = nlpRequestModel.getWebDriver();

		// Your program element business logic goes here ...
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			List<WebElement> numDeleteIcons = driver.findElements(By.xpath(DeleteIcon));
			try {
			if (numDeleteIcons.size() > 0) {
				for (int i = 1; i <= numDeleteIcons.size(); i++) {
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DeleteIcon)));
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DeleteIcon))).click();
					Thread.sleep(1000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RemoveButton)));
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(RemoveButton))).click();
					Thread.sleep(1000);
					nlpResponseModel.setMessage(numDeleteIcons.size()+"  Product Deleted Successfully");
					nlpResponseModel.setStatus(CommonConstants.pass);
				}
			}else {
				driver.navigate().refresh();
				if (driver.findElement(By.xpath("//div[text()='Oops!']")).isDisplayed()) {
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