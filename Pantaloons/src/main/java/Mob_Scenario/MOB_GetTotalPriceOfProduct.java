package Mob_Scenario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;



@Component("LIC1710_PJT1013_PE_NLP143ca303-e61a-4380-aac2-f1f92a1b7e16")
public class MOB_GetTotalPriceOfProduct implements Nlp {
	
    @InputParams({@InputParam(name = "productPrice", type = "java.lang.String"),
    	@InputParam(name = "quantity", type = "java.lang.String")})
    @ReturnType(name = "totalPrice", type = "java.lang.String")

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
          String totalPrice=null;
          
      
          try {
        	  String productPrice = (String) attributes.get("productPrice");
        	  String quantity = (String) attributes.get("quantity");
        	  int multi=Integer.parseInt(productPrice)*Integer.parseInt(quantity);
        	  totalPrice=Integer.toString(multi);
        		 
        		 
        	 nlpResponseModel.setStatus(CommonConstants.pass);
        	 nlpResponseModel.setMessage("Price of the product "+totalPrice);
        	 
        	  
          }catch(Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.fail);
 			 nlpResponseModel.setMessage("Fail to get the price of the product"+e);
          }

         
          nlpResponseModel.getAttributes().put("priceTotal", totalPrice);
          return nlpResponseModel;
      }
  } 