package Mob_Scenario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import io.appium.java_client.AppiumDriver;

@Component("LIC1710_PJT1013_PE_NLP2edbe826-2156-4a34-b906-195ab4ae7dea")
public class Mob_ValidateTheQuantityOfSizesLeft implements Nlp {
	@InputParams({ @InputParam(name = "availableSize", type = "java.lang.String"),
			@InputParam(name = "selectSize", type = "java.lang.String"),
			@InputParam(name = "quantityPlusIcon", type = "java.lang.String") })

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
		String availableSize = (String) attributes.get("availableSize");
		String selectSize = (String) attributes.get("selectSize");
		String quantityPlusIcon = (String) attributes.get("quantityPlusIcon");
		AppiumDriver driver = nlpRequestModel.getAndroidDriver();

		try {
			List<WebElement> quantityLeft = driver.findElements(By.xpath(availableSize));
			String getQuantity = quantityLeft.get(0).getText().replaceAll("[^0-9?]", "");
			int Quantity = Integer.parseInt(getQuantity);

			List<WebElement> sizesAvailable = driver.findElements(By.xpath(selectSize));
			sizesAvailable.get(0).click();
			if (Quantity == 1) {
				nlpResponseModel.setMessage("Available size is" + " " + getQuantity);
				nlpResponseModel.setStatus(CommonConstants.pass);
			} else {
				for (int i = 1; i <= Quantity; i++) {
					driver.findElement(By.xpath(quantityPlusIcon)).click();
				}
				nlpResponseModel.setMessage("Sucessfully Clicked on Quantity Plus icon");
				nlpResponseModel.setStatus(CommonConstants.pass);

			}
		} catch (NoSuchElementException e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to Locate the Element" + e);
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Something Went Wrong" + e);
		}

		return nlpResponseModel;
	}
}
