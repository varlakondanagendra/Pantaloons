
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

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

  @Component("LIC1710_PJT1013_PE_NLPc8f8b892-0687-45be-98ac-f9efb4e1cd89")
  public class MOB_ExtractStringToSubString implements Nlp {
      @InputParams({@InputParam(name = "String", type = "java.lang.String"), 
    	  @InputParam(name = "Start Index", type = "java.lang.Integer"),
      @InputParam(name = "End Index", type = "java.lang.Integer")})
      @ReturnType(name = "Assign Return To", type = "java.lang.String")

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
          String string1 = (String) attributes.get("String");
          Integer startIndex = (Integer) attributes.get("Start Index");
          Integer endIndex = (Integer) attributes.get("End Index");

          // Your program element business logic goes here ...
          String string2 = null;
          try {
        	  
        	  string2=string1.substring(startIndex, endIndex);
        	  nlpResponseModel.setStatus(CommonConstants.pass);
        	  nlpResponseModel.setMessage("Extracted Substring Is "+string2+"");
        	    
          }catch(Exception e){
        	  nlpResponseModel.setStatus(CommonConstants.fail);
        	  nlpResponseModel.setStatus("Failed to convert String To SubString");  
          } 
          nlpResponseModel.getAttributes().put("Assign Return To", string2);
          return nlpResponseModel;
      }
  } 