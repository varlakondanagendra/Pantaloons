package Mob_web_Scenario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;

import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("LIC1710_PJT1013_PE_NLPb82221ec-3f25-4171-9776-cd3411ad66b2")
public class MOB_SwitchfromNativeViewToWebView implements Nlp {

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
			AndroidDriver driver = (AndroidDriver) nlpRequestModel.getDriver().getSpecificIDriver();
			Set<String> allContextHandles = driver.getContextHandles();
//            log.info("Available contexts are {}", allContextHandles);
            String notNativeContext = allContextHandles.stream().filter(context -> !context.contains("NATIVE"))
                    .map(Object::toString).findAny().orElse(null);
            if (Objects.nonNull(notNativeContext)) {
                driver.context(notNativeContext);
                nlpResponseModel.setMessage("Successfully switched to WEBVIEW");
                nlpResponseModel.setStatus(CommonConstants.pass);
            } else {
                nlpResponseModel.setMessage("Context WEBVIEW is not available to switch");
                nlpResponseModel.setStatus(CommonConstants.fail);
            }
		} catch (Exception e) {
//			log.error("Exception is: ", e);
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to switch to webview");
		}
		return nlpResponseModel;
	}
}