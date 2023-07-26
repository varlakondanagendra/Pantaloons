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



@Component("LIC1710_PJT1013_PE_NLP9586f14e-f6f3-4f1f-9e85-5aceea752430")
public class To_Fetch_ProductAttributeId  implements Nlp {
	public String v=null;
	@InputParams({@InputParam(name = "Response Body", type = "java.lang.String")})
	@ReturnType(name = "ID", type = "java.lang.String")

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
		String text = (String) attributes.get("Response Body");
		//String string2 = (String) attributes.get("string2");
		String textString = null;
		String value1 = null;
		// Your program element business logic goes here ...
		try {
			textString = text.replaceAll("\\\\", "");
			//String filePath = "C:\\Users\\user\\Downloads\\as.txt";
			String valueToFetch = "\"Quantity\":";
			//String value = "\"Quantity\":0";

			
			int q = -1;

			int index = 0;
			int f = 0;

			while (q<1) {

				index = textString.indexOf(valueToFetch, index+4);//
				//System.out.println(index);

				f = textString.indexOf(',', index);
				//System.out.println(f);

				 value1 = textString.substring(index + 11, f);
				q = Integer.parseInt(value1);
			//	System.out.println(q);

				if (q > 0) {
					f = textString.indexOf('}', index);
					index = textString.indexOf("\"ID\"", index);
					value1 = textString.substring(index + 5, f);
				//	System.out.println(q);
				//	System.out.println(value1);
				}
			}
			v=value1.replaceAll("\"", "");
//			System.out.println(v);

			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("ID is fetched Successfully");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to fetch the ID"+e);
		}

		//String string3 = "Return Value";
		nlpResponseModel.getAttributes().put("ID", v);
		return nlpResponseModel;
	}
	
}  
