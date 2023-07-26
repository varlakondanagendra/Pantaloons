package Mob_Scenario;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component("LIC1710_PJT1013_PE_NLP4605c8ac-0024-4f19-8fa8-aea52d6c577a")
public class MOB_Compare implements Nlp {
	@InputParams({ @InputParam(name = "String_Xpath_1", type = "java.lang.String"),
			@InputParam(name = "String_Xpath_2", type = "java.lang.String"),
			@InputParam(name = "Select Your Option(asc/desc)", type = "java.lang.String") })
	@ReturnType(name = "Values", type = "java.util.ArrayList")

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
		String String_Xpath_1 = (String) attributes.get("String_Xpath_1");
		String String_Xpath_2 = (String) attributes.get("String_Xpath_2");
		String option = (String) attributes.get("Select Your Option(asc/desc)");
		AppiumDriver driver = nlpRequestModel.getAndroidDriver();
		Boolean condition = null;
		ArrayList<Integer> listofValues = new ArrayList<Integer>();
		try {
			String value1A = driver.findElement(By.xpath(String_Xpath_1)).getText();
			String value2A = driver.findElement(By.xpath(String_Xpath_2)).getText();
			Integer value1B = Integer.parseInt(value1A.replaceAll("[^0-9]", ""));
			Integer value2B = Integer.parseInt(value2A.replaceAll("[^0-9]", ""));
			listofValues.add(0, value1B);
			listofValues.add(1, value2B);
			if (option.equalsIgnoreCase("asc")) {
				if (value1B <= value2B){
					condition = true;
					nlpResponseModel.setStatus(CommonConstants.pass);
					nlpResponseModel.setMessage("The Data is in Ascending Order");
				} else {
					nlpResponseModel.setStatus(CommonConstants.fail);
					nlpResponseModel.setMessage("The Data is Not in Ascending Order");
				}
			}
			if (option.equalsIgnoreCase("desc")) {
				if (value2B<= value1B) {
					condition = true;
					nlpResponseModel.setStatus(CommonConstants.pass);
					nlpResponseModel.setMessage("The Data is in Descending Order");
				} else {
					nlpResponseModel.setStatus(CommonConstants.fail);
					nlpResponseModel.setMessage("The Data is Not in Descending Order");
				}
			}
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Something Went Wrong"+e);
		}

		nlpResponseModel.getAttributes().put("Values", listofValues);
		return nlpResponseModel;
	}
}
