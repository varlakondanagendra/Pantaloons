package Mob_Scenario;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
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
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import aj.org.objectweb.asm.Handle;
import io.appium.java_client.android.AndroidDriver;


@Component("LIC1710_PJT1013_PE_NLP52c801c8-db0c-475e-8d9d-8115de414e6c")
public class MOB_GetTextFromListOfWebElement implements Nlp {
	@InputParams({@InputParam(name = "xpath", type = "java.lang.String")})
	 @ReturnType(name = "list", type = "java.util.ArrayList")
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
		String xpath=(String) attributes.get("xpath");
		ArrayList arr= new ArrayList();
		try {
			AndroidDriver driver=(AndroidDriver) nlpRequestModel.getDriver().getSpecificIDriver();
			List<WebElement> name=driver.findElements(By.xpath(xpath));
	      
			for(WebElement text:name) {
				String size=text.getText();
				arr.add(size);
			}
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully get the text from list of webelement"+arr);

		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to get the text"+e);
		}
		nlpResponseModel.getAttributes().put("list",arr);
		return nlpResponseModel;
	}
}
