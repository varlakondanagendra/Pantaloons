package Mob_web_Scenario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("LIC1710_PJT1013_PE_NLPb56ca982-0141-4cd7-8947-2a027948bb1c")
public class MOB_GetTextFromMessage implements Nlp {
	@InputParams({@InputParam(name = "Message Element Xpath", type = "java.lang.String")})
	@ReturnType(name = "MessageText", type = "java.lang.String")

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
		String messageText = null;
		try {
			String xpath = (String) attributes.get("Message Element Xpath");
			AndroidDriver driver=(AndroidDriver) nlpRequestModel.getDriver().getSpecificIDriver();
//			log.info("Value of driver: {}, Value of xpath: {}", driver, xpath);
			Thread.sleep(5000);
			messageText = driver.findElement(By.xpath(xpath)).getText();
			driver.navigate().back();
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Sucessefully fetched text from message: " + messageText);	
		}
		catch(Exception e) {
//			log.error("Exception is: ", e);
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("failed to fetch text from message");
		}
		nlpResponseModel.getAttributes().put("MessageText", messageText);
		return nlpResponseModel;
	}
} 
