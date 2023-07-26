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
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component("LIC1710_PJT1013_PE_NLPae7629c5-542b-4728-8ca9-9c2df416b726")
public class Verify_If_SizeChart_isDisplayed_then_click implements Nlp {
	@InputParams({ @InputParam(name = "xpath", type = "java.lang.String") })
	// @ReturnType(name = "string3", type = "java.lang.String")

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
		String xpath = (String) attributes.get("xpath");
		// String string2 = (String) attributes.get("string2");
		// WebElement element = (WebElement) attributes.get("element");
		WebDriver driver = (WebDriver) nlpRequestModel.getDriver().getSpecificIDriver();

		// Your program element business logic goes here ...
		try {
			WebElement element = driver.findElement(By.xpath(xpath));
			if (element.isDisplayed()) {

				nlpResponseModel.setStatus(CommonConstants.pass);
				nlpResponseModel.setMessage("Size chart is displayed");

			} else {
				nlpResponseModel.setStatus(CommonConstants.pass);
				nlpResponseModel.setMessage("Size chart is not displayed");

			}

		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to click on Element");

		}

		return nlpResponseModel;
	}
}
