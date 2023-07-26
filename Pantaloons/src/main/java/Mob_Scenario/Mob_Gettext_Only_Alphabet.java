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

import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component("LIC1710_PJT1013_PE_NLPa9acb9e8-8f31-48e1-b86c-49be93105298")
public class Mob_Gettext_Only_Alphabet implements Nlp {
	
    @InputParams({@InputParam(name = "element", type = "org.openqa.selenium.WebElement"),
    	@InputParam(name = "elementName", type = "java.lang.String"),
    	@InputParam(name = "elementType", type = "java.lang.String"),})
    @ReturnType(name = "onlyAlphabets", type = "java.lang.String")

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
         
       WebElement   element = (WebElement) attributes.get("element");
          String onlyAlphabet=null;
          try {
        	  
        	  onlyAlphabet=element.getText().replaceAll("[0-9!-@_^]", "").trim();
        	 
        	 nlpResponseModel.setStatus(CommonConstants.pass);
        	 nlpResponseModel.setMessage("Sucessfully fetch the only Alphabet "+onlyAlphabet);
        	 
        	  
          }catch(Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.fail);
 			 nlpResponseModel.setMessage("Fail to fetch the only Alphabet"+e);
          }

         
          nlpResponseModel.getAttributes().put("onlyAlphabets", onlyAlphabet);
          return nlpResponseModel;
      }
  } 