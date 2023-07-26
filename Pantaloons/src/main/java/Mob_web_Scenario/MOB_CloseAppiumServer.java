package Mob_web_Scenario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import org.springframework.stereotype.Component;

@Component("LIC1710_PJT1013_PE_NLPf80f351e-c9e2-4b9b-8fc0-aa2b6dc6c9bf")
public class MOB_CloseAppiumServer implements Nlp {
	@InputParams({@InputParam(name = "Task", type = "java.lang.String")})

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
		String Task = (String) attributes.get("Task");
		try {
			Runtime.getRuntime().exec(Task);
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Application Closed");
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to Close Application");

		}
		return nlpResponseModel;
	}
} 