package WEB_Scenario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebElement;
import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import org.springframework.stereotype.Component;

@Component("LIC1710_PJT1013_PE_NLPad7d59ce-0ecb-4428-8d8e-22d49b1ff62d")
public class WEB_Fetch_Only_DiscountedAmount_Of_The_Product implements Nlp {
	@InputParams({@InputParam(name = "element", type = "org.openqa.selenium.WebElement")})
		@ReturnType(name = "FetchedDetails", type = "java.lang.String")

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
		WebElement element = (WebElement) attributes.get("element");
		
		String s2=null;
		try {
			String ch=element.getText();
			String[] ch1=ch.split(" ");
			s2=ch1[1];
			
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Amount Fetched "+s2);
		}catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Amount Not Fetched "+e);
		}
		nlpResponseModel.getAttributes().put("FetchedDetails", s2);
		return nlpResponseModel;
	}
} 