package WEB_Scenario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import org.springframework.stereotype.Component;

@Component("LIC1710_PJT1013_PE_NLP07743b52-cca9-4b9f-a1b8-f085653f645d")
public class WEB_VerifyUserIsAbleToSelectProductOfAvailableSize implements Nlp {
	@InputParams({@InputParam(name = "productLocator", type = "java.lang.String"),
		@InputParam(name = "sizeLocator", type = "java.lang.String"),
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
		String sizeLocator = (String) attributes.get("sizeLocator");
		Integer numberOfAttempts = (Integer) attributes.get("numberOfAttempts");
		try {
			WebDriver driver=(WebDriver)nlpRequestModel.getDriver().getSpecificIDriver();

			//--------------------------------------------------------------------
			List<WebElement>availableSizes = new ArrayList<WebElement>();

			for(int i=1;i<=numberOfAttempts;i++) {
				driver.findElement(By.xpath(productLocator+"["+i+"]")).click();

				List<WebElement> dressSizes = driver.findElements(By.xpath(sizeLocator));
				int sizes = dressSizes.size();

				if(sizes>=1) {
					availableSizes.add(dressSizes.get(0));
					break;
				}
				else {
					driver.navigate().back();
				}
			}
			if(availableSizes.isEmpty()) {
				nlpResponseModel.setStatus(CommonConstants.fail);
				nlpResponseModel.setMessage("Could not find the product sizes for numberOfAttempts products");
				
			}else {
				WebElement availableSize = availableSizes.get(0);			
				availableSize.click();
				
				nlpResponseModel.setStatus(CommonConstants.pass);
				nlpResponseModel.setMessage("Selected the available size");
				
			} 
		}catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Could not check the available sizes for "+numberOfAttempts+" products");
		}

		return nlpResponseModel;
	}
} 