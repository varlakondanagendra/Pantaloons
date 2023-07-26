
package Mob_Scenario;

import com.google.common.collect.ImmutableMap;
import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import java.util.Map;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("LIC1710_PJT1013_PE_NLPacdf2214-ccfd-4a4b-b567-0a3e867fd29e")
public class PressDoneKey implements Nlp {
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
         try {
        	 AndroidDriver driver=(AndroidDriver) nlpRequestModel.getDriver().getSpecificIDriver();
        	 driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "done"));
        	 nlpResponseModel.setStatus(CommonConstants.pass);
 			 nlpResponseModel.setMessage("Successfuly Pressed on done key");
         }
         catch(Exception e) {
        	 nlpResponseModel.setStatus(CommonConstants.fail);
 			 nlpResponseModel.setMessage("Fail To press done key"+e);
         }
         
          return nlpResponseModel;
      }
  } 