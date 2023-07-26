package WEB_Scenario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import org.springframework.stereotype.Component;

@Component("LIC1710_PJT1013_PE_NLP546e02cc-fdc9-44d2-bb12-0edb2468270d")
public class WEB_QuitDriverInstance implements Nlp {

	@InputParams({@InputParam(name = "driverInstance", type = "java.lang.org.openqa.selenium.WebDriver")})


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
		WebDriver driver=(WebDriver) attributes.get("driverInstance");
		try {
			
			if(driver.equals(null)) {
				driver.quit();
				nlpResponseModel.setMessage(CommonConstants.pass);
				nlpResponseModel.setStatus("driver instance quit succesfully");
			}
			else {
				driver.quit();
			nlpResponseModel.setMessage(CommonConstants.pass);
			nlpResponseModel.setStatus("driver instance quit succesfully");
			}
		} catch (Exception e) {
			driver.quit();
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setStatus("Closed successfully");
		}

		return nlpResponseModel;
	}
}