package WEB_Scenario;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component("LIC1710_PJT1013_PE_NLP0bd4fe3b-2094-4552-8cd1-36d54accf46c")
public class WEB_RemoveSpaceFromWords implements Nlp {
    @InputParams({@InputParam(name = "ProductPrice", type = "java.lang.String")})
    @ReturnType(name = "productPriceWithoutSpace", type = "java.lang.String")

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
          
          String value="";
          try {
        	  String ProductPrice = (String) attributes.get("ProductPrice");
        	  value=ProductPrice.replaceAll("\\s", "");
        	  nlpResponseModel.setStatus(CommonConstants.pass);
        	  nlpResponseModel.setMessage("Successfully cleared the spaces"+value);
        	  
          }
          catch(Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.fail);
        	  nlpResponseModel.setMessage("fail to clear the spces"+e);
          }

          
          nlpResponseModel.getAttributes().put("productPriceWithoutSpace", value);
          return nlpResponseModel;
      }
  } 