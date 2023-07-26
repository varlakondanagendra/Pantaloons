package WEB_Scenario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import org.springframework.stereotype.Component;

@Component("LIC1710_PJT1013_PE_NLP4ef9d620-766f-4f38-b09f-b4c88f3fceb2")
public class WEB_VerifyElementIsDisplayedForNTimesInPDP implements Nlp {
	@InputParams({@InputParam(name = "productLocator", type = "java.lang.String"),
		@InputParam(name = "elementXpath", type = "java.lang.String"),
		@InputParam(name = "numberOfAttempts", type = "java.lang.Integer")})

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
		String productLocator = (String) attributes.get("productLocator");
		String elementXpath = (String) attributes.get("elementXpath");
		Integer numberOfAttempts = (Integer) attributes.get("numberOfAttempts");
		
		WebDriver driver=(WebDriver)nlpRequestModel.getWebDriver();
		Boolean isDisplayed=null;
	    for(int i=1;i<=numberOfAttempts;i++) { 
			 driver.findElement(By.xpath(productLocator+"["+i+"]")).click();
			 try {
		     isDisplayed= driver.findElement(By.xpath(elementXpath)).isDisplayed();
			 if(isDisplayed==true) {
				 nlpResponseModel.setStatus(CommonConstants.pass);
				 nlpResponseModel.setMessage("Successfully Found the element");
				 break;
				 } 
			 }
		     catch(NoSuchElementException e) {
		     isDisplayed=false;
			 driver.navigate().back();
			 nlpResponseModel.setStatus(CommonConstants.pass);
			 nlpResponseModel.setMessage("Successfully Navigated to Previous Page");
		     }
			 catch (java.lang.IllegalArgumentException e) {
	         isDisplayed = false;
	         driver.navigate().back();
			 nlpResponseModel.setStatus(CommonConstants.pass);
			 nlpResponseModel.setMessage("Successfully Navigated to Previous Page");
			 }
			 catch(Exception e) {
				nlpResponseModel.setStatus(CommonConstants.fail);
				nlpResponseModel.setMessage("Failed to locate the element");
			 }
		 }
		return nlpResponseModel;
	}
} 