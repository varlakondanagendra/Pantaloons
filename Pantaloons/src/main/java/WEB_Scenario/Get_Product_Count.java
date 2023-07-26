
package WEB_Scenario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

@Component("LIC1710_PJT1013_PE_NLP9fcf906f-349b-4661-b8ff-5bef5796a27a")
public class Get_Product_Count implements Nlp {
    @InputParams({@InputParam(name = "filterProductCount", type = "java.lang.String"),
    	})
    @ReturnType(name = "productCount", type = "java.lang.String")

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
         String filterProductCount = (String) attributes.get("filterProductCount");
          String number=null;
          try {
        	  WebDriver driver=(WebDriver)nlpRequestModel.getDriver().getSpecificIDriver();
			String message=filterProductCount;
		 number=message.replaceAll("[^0-9]", "");
		 nlpResponseModel.setMessage("Sucessufully fetched Product count"+" "+number);
		 nlpResponseModel.setStatus(CommonConstants.pass);
		} catch (Exception e) {
			 nlpResponseModel.setMessage("Failed to fetch the Onlu Numbers"+""+e);
			 nlpResponseModel.setStatus(CommonConstants.fail);
		}
         
          
          nlpResponseModel.getAttributes().put("productCount", number);
          return nlpResponseModel;
      }
  } 