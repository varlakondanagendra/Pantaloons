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


@Component("LIC1710_PJT1013_PE_NLP01fb30d1-5b8c-4c53-bff3-07329371d571")
public class MOB_concatenate_two_String implements Nlp {
	@InputParams({ @InputParam(name = "String_1", type = "java.lang.String"),
			@InputParam(name = "String_2", type = "java.lang.String") })
	@ReturnType(name = "String_3", type = "java.util.String")

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
		String String_1 = (String) attributes.get("String_1");
		String String_2 = (String) attributes.get("String_2");
		String String_3="";
		
		try {
			String_3=String_1.concat(String_2);
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully concatenated "+String_1+" and "+String_2);
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to concatenate"+e);
		}

		nlpResponseModel.getAttributes().put("String_3", String_3);
		return nlpResponseModel;
	}
}
