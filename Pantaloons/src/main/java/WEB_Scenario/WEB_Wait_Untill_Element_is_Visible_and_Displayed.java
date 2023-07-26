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




@Component("LIC1710_PJT1013_PE_NLP6f086139-17bb-4ed4-8b38-4765ae56ff1d")
public class WEB_Wait_Untill_Element_is_Visible_and_Displayed implements Nlp {
	 @InputParams({@InputParam(name = "Element", type = "org.openqa.selenium.WebElement"),
         @InputParam(name = "Wait", type = "java.lang.String")})
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
		  String waittime = (String) attributes.get("Wait");
          WebElement element=(WebElement) attributes.get("Element");
          Boolean isDisplayed = null;

		try {
			WebDriver driver=nlpRequestModel.getWebDriver();
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Long.parseLong(waittime)));
            wait.until(ExpectedConditions.visibilityOf(element));
            isDisplayed= element.isDisplayed();
            nlpResponseModel.setStatus(CommonConstants.pass);
            nlpResponseModel.setMessage("Successfully waited until element is visible and Displayed in Webpage");
		} catch (Exception e) {
			isDisplayed = false;
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Element Is Not Displayed In WebPage");
		}
		nlpResponseModel.getAttributes().put("isDisplayed", isDisplayed);
		return nlpResponseModel;
	}
}
