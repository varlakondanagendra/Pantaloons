
package Mob_Scenario;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.data.models.dto.IDriver;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

@Component("LIC1710_PJT1013_PE_NLP7a568548-268f-4efd-b6d4-93eb94bfcd51")
public class Mob_Launch_Pantaloons_Application implements Nlp {

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
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("appPackage", "com.pantaloons");
			cap.setCapability("appActivity", "com.pantaloons.MainActivity");
			cap.setCapability("noReset", true);
			AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
			

			nlpResponseModel.setAndroidDriver(driver);

			nlpResponseModel.setMessage("Successfully Launched Pantaloons Application");
			nlpResponseModel.setStatus(CommonConstants.pass);
		} catch (Exception e) {
			nlpResponseModel.setMessage("Failed to Launch Pantaloons Application");
			nlpResponseModel.setStatus(CommonConstants.fail);
		}
		return nlpResponseModel;
	}
}