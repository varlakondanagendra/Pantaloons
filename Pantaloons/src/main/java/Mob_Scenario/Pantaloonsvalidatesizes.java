package Mob_Scenario;

import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.tyss.optimize.nlp.util.*;
import com.tyss.optimize.common.util.CommonConstants;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

@SuppressWarnings("unchecked")


@Component("LIC1710_PJT1013_PE_NLP050e844c-1449-47e3-8a19-18da07449d0f")
public class Pantaloonsvalidatesizes implements Nlp {
	WebDriver driver = null;

	@InputParams({ @InputParam(name = "StrikedOut", type = "java.lang.String"),
			@InputParam(name = "Notify", type = "java.lang.String"),
			@InputParam(name = "GetNotifiedSizes", type = "java.lang.String") })

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
		String strikedOut = (String) attributes.get("StrikedOut");
		String notify = (String) attributes.get("Notify");
		String getNotifiedSizes = (String) attributes.get("GetNotifiedSizes");
		driver = (WebDriver) nlpRequestModel.getDriver().getSpecificIDriver();

		// Your program element business logic goes here ...

		try {

			ArrayList l1 = new ArrayList();
			ArrayList l2 = new ArrayList();
			List<WebElement> list = driver.findElements(By.xpath(strikedOut));
			for (WebElement list1 : list) {
				l1.add(list1.getText());
			}
			driver.findElement(By.xpath(notify)).click();
			List<WebElement> notify_sizes = driver.findElements(By.xpath(getNotifiedSizes));
			for (WebElement list2 : notify_sizes) {
				l2.add(list2.getText());
			}
			if (l1.equals(l2)) {

				nlpResponseModel.setStatus(CommonConstants.pass);
				nlpResponseModel.setMessage("Sizes are matching");
			} else {
				nlpResponseModel.setStatus(CommonConstants.fail);
				nlpResponseModel.setMessage("Sizes are not matching");
			}

		} catch (Exception e) {

			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to match the size");
		}

		return nlpResponseModel;
	}
}