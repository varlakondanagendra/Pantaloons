package Mob_Scenario;

import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;  
import com.tyss.optimize.nlp.util.annotation.InputParam; 
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import com.tyss.optimize.common.util.CommonConstants;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import static io.appium.java_client.service.local.flags.GeneralServerFlag.BASEPATH;



@Component("LIC1710_PJT1013_PE_NLP3f2087c1-0a58-44e4-b163-7136ec255f6b")
public class StopAppium  implements Nlp {
	private static AppiumDriverLocalService appiumService;
	@InputParams({@InputParam(name = "appium Service", type = "io.appium.java_client.service.local.AppiumDriverLocalService")
		})
	

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
		
		AppiumDriverLocalService service = (AppiumDriverLocalService) attributes.get("appium Service");
		try {
			service.stop();
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Stopped appium server successfully");

		} catch (Exception e) {
			e.printStackTrace();
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to stop appium server");
		}
		
		return nlpResponseModel;
	}

} 


