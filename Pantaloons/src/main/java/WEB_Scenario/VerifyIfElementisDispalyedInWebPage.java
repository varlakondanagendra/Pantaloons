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




@Component("LIC1710_PJT1013_PE_NLP917bef4d-f1cf-4421-a8fc-f81f461f8f32")
public class VerifyIfElementisDispalyedInWebPage implements Nlp {
	@InputParams({ @InputParam(name = "xpath", type = "java.lang.String")})
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

		Boolean isDisplayed = null;
		try {
			String xpath=(String) attributes.get("xpath");
			WebDriver driver=nlpRequestModel.getWebDriver();
			isDisplayed =driver.findElement(By.xpath(xpath)).isDisplayed();
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Element Is Displayed In WebPage");
		} catch (Exception e) {
			isDisplayed = false;
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Element Is Not Displayed In WebPage");

		}

		nlpResponseModel.getAttributes().put("isDisplayed", isDisplayed);
		return nlpResponseModel;
	}
}
