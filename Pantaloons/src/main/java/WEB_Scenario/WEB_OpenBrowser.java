package WEB_Scenario;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

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

@Component("LIC1710_PJT1013_PE_NLP62894f5b-4202-49b2-97a1-6b93ab9504ec")
public class WEB_OpenBrowser implements Nlp {

	@InputParams({@InputParam(name = "hubUrl", type = "java.lang.String"),
		@InputParam(name = "capabilities", type = "java.lang.org.openqa.selenium.Capabilities")})
	@ReturnType(name = "driverInstance", type = "java.lang.org.openqa.selenium.WebDriver")


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
		IDriver driver1=null;
		try {
			String hubUrl=(String) attributes.get("hubUrl");
			Capabilities capabilities=(Capabilities) attributes.get("capabilities");
		 driver=new RemoteWebDriver(new URL(hubUrl), capabilities);
		  driver1 = new com.tyss.optimize.data.models.dto.drivers.WebDriver(driver);
			nlpResponseModel.setDriver(driver1);
			nlpResponseModel.setMessage(CommonConstants.pass);
			nlpResponseModel.setStatus("Successfully launched the browser");
			
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setStatus("Fail to launch the browser");
		}
		
		nlpResponseModel.getAttributes().put("driverInstance", driver1);
		return nlpResponseModel;
	}
}