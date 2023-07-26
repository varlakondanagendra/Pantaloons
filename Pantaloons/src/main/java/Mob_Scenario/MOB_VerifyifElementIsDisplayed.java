package Mob_Scenario;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import io.appium.java_client.android.AndroidDriver;


import org.springframework.stereotype.Component;

@Component("LIC1710_PJT1013_PE_NLP59fbfacd-71d3-41b2-b985-8fb2095da367")
public class MOB_VerifyifElementIsDisplayed implements Nlp {
	@InputParams({@InputParam(name = "list", type = "java.util.List")})
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
		List list=(List) attributes.get("list");
		Boolean isDisplayed=null;
		try {
			AndroidDriver driver=(AndroidDriver) nlpRequestModel.getDriver().getSpecificIDriver();
			for(int i=0;i<list.size();i++) {
				isDisplayed=driver.findElement(By.xpath("//android.widget.TextView[@text='"+list.get(i)+"']")).isDisplayed();
				if(isDisplayed==true) {
					nlpResponseModel.setStatus(CommonConstants.pass);
					nlpResponseModel.setMessage("No of Elements Displayed in Screen is  "+list.size());
				}
				else {
					nlpResponseModel.setStatus(CommonConstants.fail);
					nlpResponseModel.setMessage("The Element which is not displayed on screen is  "+list.get(i));
				}
			}

		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to locate the elements in screen "+e);
		}
		nlpResponseModel.getAttributes().put("isDisplayed",isDisplayed);
		return nlpResponseModel;
	}
}
