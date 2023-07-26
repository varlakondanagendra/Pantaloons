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



@Component("LIC1710_PJT1013_PE_NLPc4c3f7e1-ad7f-4730-a912-e5a8c9ee9f4b")
public class StartAppiumServer  implements Nlp {
	private static AppiumDriverLocalService appiumService;
	@InputParams({@InputParam(name = "Main JS path", type = "java.lang.String"),
		@InputParam(name = "Node path", type = "java.lang.String")})
	@ReturnType(name = "appium Service", type = "io.appium.java_client.service.local.AppiumDriverLocalService")

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
		String mainJS = (String) attributes.get("Main JS path");
		String node = (String) attributes.get("Node path");
		String hubURL = null;
		AppiumDriverLocalService service = null;
		try {
			startAppiumServer(mainJS, node);
			service=appiumService;
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Appium server started successfully");

		} catch (Exception e) {
			e.printStackTrace();
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to start appium server");
		}
		nlpResponseModel.getAttributes().put("appium Service", service);
		return nlpResponseModel;
	}

	private static void startAppiumServer(String mainJS, String node)
	{
		AppiumServiceBuilder builder = new AppiumServiceBuilder ();
		builder.withIPAddress ("127.0.0.1")
		//                .usingAnyFreePort()
		.usingPort (4725)
		.withAppiumJS (
				new File (mainJS))
		.usingDriverExecutable (new File (node))
		.withArgument (BASEPATH, "/wd/hub")
		.withArgument (GeneralServerFlag.SESSION_OVERRIDE)
		.withArgument (GeneralServerFlag.LOG_LEVEL, "error");
		appiumService = AppiumDriverLocalService.buildService (builder);
		appiumService.start ();

	}
} 


