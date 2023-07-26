package Mob_Scenario;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component("LIC1710_PJT1013_PE_NLP89710854-102f-4723-aac0-221c0c2efab0")
public class MOB_ClearTextValueFromElement implements Nlp {
	@InputParams({ @InputParam(name = "elementName", type = "java.lang.String"),
			@InputParam(name = "elementType", type = "java.lang.String"),
			@InputParam(name = "element", type = "org.openqa.selenium.WebElement")})

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
		WebElement element = (WebElement) attributes.get("element");

		try {
			
			if(element.isDisplayed() &&  element.isEnabled()){
		    Thread.sleep(1000);
			element.clear();
			}
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully Cleared The Text From Element");

		} catch (NoSuchElementException e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed To Locate The Element");

		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed To Clear The Text From Element");
		}
		return nlpResponseModel;
	}
}
