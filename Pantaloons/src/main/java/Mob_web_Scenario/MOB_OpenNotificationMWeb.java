package Mob_web_Scenario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;

import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("LIC1710_PJT1013_PE_NLP57a191c2-b40e-49b6-b5f5-894d2a048c35")
public class MOB_OpenNotificationMWeb implements Nlp {
	

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
		
		try {
			AndroidDriver driver=(AndroidDriver) nlpRequestModel.getDriver().getSpecificIDriver();
			driver.openNotifications();
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Notification opened successfully");	
		}
		catch(Exception e) {
//			log.error("Exception is: ", e);
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to open notification");
		}
		return nlpResponseModel;
	}
} 
