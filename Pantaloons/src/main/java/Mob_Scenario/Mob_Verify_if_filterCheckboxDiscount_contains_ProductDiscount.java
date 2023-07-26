package Mob_Scenario;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import io.appium.java_client.android.AndroidDriver;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("LIC1710_PJT1013_PE_NLPae0e6ab4-b468-4656-9aee-ee7e93a4d94b")
public class Mob_Verify_if_filterCheckboxDiscount_contains_ProductDiscount implements Nlp {

	@InputParams({ @InputParam(name = "productDiscount", type = "java.lang.String"),
			@InputParam(name = "checkboxDiscount", type = "java.lang.String"), })
	
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

		
		String productDiscount = (String) attributes.get("productDiscount");
		String checkboxDiscount = (String) attributes.get("checkboxDiscount");
		
		try {
			checkboxDiscount=checkboxDiscount.substring(0,5);//10-20
			
			int value1=Integer.parseInt(checkboxDiscount.substring(0,2));
			int value2=Integer.parseInt(checkboxDiscount.substring(3,5));
			int plpdiscount=Integer.parseInt(productDiscount.substring(0, 2));
			if(plpdiscount>=value1 || plpdiscount<=value2) {
			 nlpResponseModel.setStatus(CommonConstants.pass);
			 nlpResponseModel.setMessage(checkboxDiscount +" "+"Contains"+""+productDiscount);
			}
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage(productDiscount +" "+"Does not Contains"+checkboxDiscount + e);
		}

		return nlpResponseModel;
	}
}