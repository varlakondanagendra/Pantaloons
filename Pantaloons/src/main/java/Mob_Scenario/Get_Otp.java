package Mob_Scenario;

import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;  
import com.tyss.optimize.nlp.util.annotation.InputParam; 
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;
import com.tyss.optimize.common.util.CommonConstants;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;



@Component("LIC1710_PJT1013_PE_NLP69ba544f-9694-41f4-92a4-df0ae6ebf41f")
public class Get_Otp  implements Nlp {
	@InputParams({@InputParam(name = "Message with OTP", type = "java.lang.String")})
	@ReturnType(name = "OTP", type = "java.lang.Integer")

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
		String message = (String) attributes.get("Message with OTP");
		Integer otp = 0;
		try {
		    message = message.replaceAll("[^0-9?]", "");
			otp = Integer.parseInt(message.substring(0, 6));
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Mobile OTP Fetched successfully "+otp);

		} catch (Exception e) {
			e.printStackTrace();
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to Fetch Mobile OTP");
		}
		nlpResponseModel.getAttributes().put("OTP", otp);
		return nlpResponseModel;
	}
} 


