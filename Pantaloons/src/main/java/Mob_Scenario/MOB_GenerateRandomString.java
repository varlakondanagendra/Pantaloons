
package Mob_Scenario;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;
import java.util.Map;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("LIC1710_PJT1013_PE_NLP0f05a1d6-dbfd-4e67-bfa0-64c0bb2979aa")
public class MOB_GenerateRandomString implements Nlp {
	@InputParams({ @InputParam(name = "size", type = "java.lang.Integer") })
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
		Integer size = (Integer) attributes.get("size");
		
		String string3 = "";
		char a;
		// Your program element business logic goes here ...
		try {

			String s = "abcdefghijklmnopqrstuvwxyz";

			Random r = new Random();
			for (int i = 1; i <= size; i++) {

				int j = r.nextInt(s.length());
				a = s.charAt(j);
				string3 = string3 + a;
				
				nlpResponseModel.setStatus(CommonConstants.pass);
				nlpResponseModel.setMessage("Generated String is "+string3);
			}
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to Generate String");
		}

		nlpResponseModel.getAttributes().put("string3", string3);
		return nlpResponseModel;
	}
}