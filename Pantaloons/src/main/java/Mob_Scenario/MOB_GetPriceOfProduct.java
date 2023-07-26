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
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("LIC1710_PJT1013_PE_NLP00ed594e-ada7-4ec1-83de-86021089e999")
public class MOB_GetPriceOfProduct implements Nlp {
	
    @InputParams({@InputParam(name = "productPrice", type = "java.lang.String")})
    @ReturnType(name = "price", type = "java.lang.String")

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
          String price=null;
          
      
          try {
        	  String productPrice = (String) attributes.get("productPrice");
        		 price=productPrice.replaceAll("[^0-9]", "");
        		 
        	 nlpResponseModel.setStatus(CommonConstants.pass);
        	 nlpResponseModel.setMessage("Price of the product "+price);
        	 
        	  
          }catch(Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.fail);
 			 nlpResponseModel.setMessage("Fail to get the price of the product"+e);
          }

         
          nlpResponseModel.getAttributes().put("priceTotal", price);
          return nlpResponseModel;
      }
  } 