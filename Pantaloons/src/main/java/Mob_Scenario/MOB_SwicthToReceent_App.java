package Mob_Scenario;




import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
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

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

@Component("LIC1710_PJT1013_PE_NLP15a96f19-98d7-489c-ab96-4a19a0582319")
public class MOB_SwicthToReceent_App implements Nlp {
	

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
		

		AndroidDriver driver=(AndroidDriver) nlpRequestModel.getDriver().getSpecificIDriver();
		
		try {
			
		
			Thread.sleep(1000);
			driver.pressKey(new KeyEvent().withKey(AndroidKey.APP_SWITCH));
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Sucessefully  Switched ");	
		}
		catch(Exception e) {
			e.printStackTrace();
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("failed to Switch "+e);
		}
		return nlpResponseModel;
	}
} 


