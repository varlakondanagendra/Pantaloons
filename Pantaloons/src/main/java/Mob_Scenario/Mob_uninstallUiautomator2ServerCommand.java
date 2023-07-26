package Mob_Scenario;

import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;  
import com.tyss.optimize.nlp.util.annotation.InputParam; 
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;
import com.tyss.optimize.common.util.CommonConstants;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;


@Component("LIC1710_PJT1013_PE_NLPeca3a72f-275a-4785-bf27-839e439e4f89")
public class Mob_uninstallUiautomator2ServerCommand  implements Nlp {
	

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
		
		try{
		Runtime rt = Runtime.getRuntime();
		Runtime.getRuntime().exec("cmd /c start cmd.exe /K "+"adb uninstall io.appium.settings");
		Thread.sleep(3000);
		//close CMD	
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		Thread.sleep(3000);
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully uninstalled appium server");
		}
		
		catch(Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed uninstalled appium server");
		}
		return nlpResponseModel;
	}
	}

