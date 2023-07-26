package API_Scenario;
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
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import org.springframework.stereotype.Component;

@Component("LIC1710_PJT1013_PE_NLPe4d7fd80-7c4f-4c94-b7ba-f12d0bbbc74e")
public class To_Fetch_SessionId implements Nlp {
	@InputParams({ @InputParam(name = "DeviceToken", type = "java.lang.String") })
	@ReturnType(name = "string3", type = "java.lang.String")

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
		 String deviceToken = (String) attributes.get("DeviceToken");
		 String strings = "";
		try {
			String string1 = deviceToken.substring(0, deviceToken.lastIndexOf('.'));
			strings = string1;
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("SessionID is fetched Successfully");
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to fetch the SessionID "+e);
		}
		nlpResponseModel.getAttributes().put("string3", strings);
		return nlpResponseModel;
	}
}
