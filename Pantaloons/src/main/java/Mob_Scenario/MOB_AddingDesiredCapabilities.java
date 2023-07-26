package Mob_Scenario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("LIC1710_PJT1013_PE_NLPe843a1bc-145e-4236-9759-4a3ba616e2ea")
public class MOB_AddingDesiredCapabilities implements Nlp {
	@InputParams({
		@InputParam(name = "Desired Capability", type = "org.openqa.selenium.remote.DesiredCapabilities"),
		@InputParam(name = "Key", type = "java.lang.String"),
		@InputParam(name = "Value in Integer", type = "java.lang.Integer") })
	@ReturnType(name = "cap", type = "org.openqa.selenium.remote.DesiredCapabilities")

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

		DesiredCapabilities cap = null;
		try {

			cap = (DesiredCapabilities) attributes.get("Desired Capability");
			String key = (String) attributes.get("Key");

			Integer value = (Integer) attributes.get("Value in Integer");



			cap.setCapability(key, value);
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Capability is set as key "+ key +" and value "+value+" in Desired Capability");
		}catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to set the capability");
		}

		nlpResponseModel.setDesiredCapabilities(cap);
		nlpResponseModel.getAttributes().put("cap", cap);

		return nlpResponseModel;

	}
}
