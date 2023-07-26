package WEB_Scenario;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;


@Component("LIC1710_PJT1013_PE_NLPf7bd4c6b-ef98-42cf-8a28-031f10621049")
public class Web_WaitUntillPageIsLoaded implements Nlp {
	 @InputParams({@InputParam(name = "Wait", type = "java.lang.Integer")})
	
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

	@SuppressWarnings("deprecation")
	@Override
	public NlpResponseModel execute(NlpRequestModel nlpRequestModel) throws NlpException {

		NlpResponseModel nlpResponseModel = new NlpResponseModel();
		Map<String, Object> attributes = nlpRequestModel.getAttributes();
		Integer waittime = (Integer) attributes.get("Wait");
		try {
			WebDriver driver=nlpRequestModel.getWebDriver();
			driver.manage().timeouts().implicitlyWait(waittime,TimeUnit.SECONDS);
            nlpResponseModel.setStatus(CommonConstants.pass);
            nlpResponseModel.setMessage("Successfully Page is Loaded");
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to load the page");
		}
		return nlpResponseModel;
	}
}
