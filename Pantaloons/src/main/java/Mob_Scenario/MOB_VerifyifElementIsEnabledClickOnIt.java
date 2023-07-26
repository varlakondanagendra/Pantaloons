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

@Component("LIC1710_PJT1013_PE_NLPc6e65d4a-72ac-4bcd-ba3c-d0a9faadce76")
public class MOB_VerifyifElementIsEnabledClickOnIt implements Nlp {
	@InputParams({@InputParam(name = "list", type = "java.util.List")})
	 @ReturnType(name = "isEnabled", type = "java.lang.Boolean")
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
		Boolean isEnabled=null;
		try {
			AndroidDriver driver=(AndroidDriver) nlpRequestModel.getDriver().getSpecificIDriver();
			for(int i=0;i<list.size();i++) {
				WebElement size=driver.findElement(By.xpath("//android.widget.TextView[@text='"+list.get(i)+"']"));
				isEnabled=size.isEnabled();
				if(isEnabled==true) {
					size.click();
					break;
				}
				
			}
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Clicked On Enabled Element");

		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to Click on Element"+e);
		}
		nlpResponseModel.getAttributes().put("isEnabled",isEnabled);
		return nlpResponseModel;
	}
}
