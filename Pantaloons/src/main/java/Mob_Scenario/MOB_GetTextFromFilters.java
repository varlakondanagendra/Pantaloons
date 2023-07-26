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


@Component("LIC1710_PJT1013_PE_NLP5a363254-df5d-4348-90e4-b6759f6ad078")
public class MOB_GetTextFromFilters implements Nlp {
	
    @InputParams({@InputParam(name = "FilterType", type = "java.lang.String")})
    @ReturnType(name = "AppliedFilter", type = "java.lang.String")

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
          String text=null;
          
      
          try {
        	  String FiltterType = (String) attributes.get("FiltterType");
        		 text=FiltterType.replaceAll("[0-9!-@_^]", "").trim();
        		 
        	 nlpResponseModel.setStatus(CommonConstants.pass);
        	 nlpResponseModel.setMessage("Applied Filter "+text);
        	 
        	  
          }catch(Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.fail);
 			 nlpResponseModel.setMessage("Fail to get the Applied Filter"+e);
          }

         
          nlpResponseModel.getAttributes().put("AppliedFilter", text);
          return nlpResponseModel;
      }
  } 