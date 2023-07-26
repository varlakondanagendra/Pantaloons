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


@Component("LIC1710_PJT1013_PE_NLP9c418454-6077-4cd4-8464-98783504c3c6")
public class Mob_Restart_VendorKey  implements Nlp {
	

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
		
		try{
			Runtime rt = Runtime.getRuntime();
			Runtime.getRuntime().exec("adb kill-server");
			Thread.sleep(3000);
			Runtime.getRuntime().exec("adb start-server");
		Thread.sleep(3000);
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully Restart the Vendor Key");
		}
		
		catch(Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to Restart the Vendor Key");
		}
		return nlpResponseModel;
	}
	}

