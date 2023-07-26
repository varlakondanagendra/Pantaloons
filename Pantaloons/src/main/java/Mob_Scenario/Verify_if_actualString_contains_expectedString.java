package Mob_Scenario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

@Component("LIC1710_PJT1013_PE_NLP5b666e9e-a902-48d7-979e-66e401090dd6")
public class Verify_if_actualString_contains_expectedString implements Nlp {
	@InputParams({ @InputParam(name = "expectedString", type = "java.lang.String"),
			@InputParam(name = "actualString", type = "java.lang.String"), })

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
		String expectedString = (String) attributes.get("expectedString");
		String actualString = (String) attributes.get("actualString");

		try {
			String[] arr1 = expectedString.split("\\s", 0);
		    String[] arr2 = actualString.split("\\s", 0);
		    for (String firstString : arr1) {   
		        for (String secondString : arr2) { 
		        	boolean caseSensitive = firstString.equalsIgnoreCase(secondString);
		        	if(caseSensitive==true) {
		            Boolean result=secondString.contains(firstString);
		            nlpResponseModel.setMessage(expectedString +""+"Contains"+""+actualString);
					nlpResponseModel.setStatus(CommonConstants.pass);
		        	}
		    else {
		    	nlpResponseModel.setMessage(expectedString +""+"Does not Contains"+""+actualString);
				nlpResponseModel.setStatus(CommonConstants.pass);
		    }
		    }
		    }
		}
		
		 catch (NoSuchElementException e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to Fetch the Element" + e);
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("NullPointerException" + e);
		}

		return nlpResponseModel;
	}
}
