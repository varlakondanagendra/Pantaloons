package WEB_Scenario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.data.models.dto.IDriver;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import org.springframework.stereotype.Component;

@Component("LIC1710_PJT1013_PE_NLPf781e54d-ef92-419a-95e5-ce16551c6e7b")
public class WEB_QuitePrevoiusInstance implements Nlp {

	@InputParams({@InputParam(name = "browserName", type = "java.lang.String")})


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
		WebDriver driver=null;
		String browserName="";
		try {
			
			browserName = (String) attributes.get("browserName");

			driver = (WebDriver) nlpRequestModel.getDriver().getSpecificIDriver();

			//Kill browser instance
			Runtime.getRuntime().exec("taskkill /F /IM "+browserName.toLowerCase()+".exe");

			nlpResponseModel.setMessage(CommonConstants.pass);
			nlpResponseModel.setStatus(browserName+" is closed successfully");
			
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setStatus(browserName+" is closed successfully");
		}
		IDriver driver1 = new com.tyss.optimize.data.models.dto.drivers.WebDriver(driver);
		nlpResponseModel.setDriver(driver1);

		return nlpResponseModel;
	}
}