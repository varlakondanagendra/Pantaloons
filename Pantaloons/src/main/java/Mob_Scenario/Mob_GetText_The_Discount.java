
package Mob_Scenario;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import io.appium.java_client.android.AndroidDriver;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component("LIC1710_PJT1013_PE_NLPa00eb308-7cd4-473e-b83f-a6a5a11ee799")
public class Mob_GetText_The_Discount implements Nlp {
	
    @InputParams({@InputParam(name = "xpath", type = "java.lang.String"),})
    @ReturnType(name = "productdiscount", type = "java.lang.String")

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
         
       String   xpath = (String) attributes.get("xpath");
          String discount=null;
          try {
        	  AndroidDriver driver=nlpRequestModel.getAndroidDriver();
        	  xpath= driver.findElement(By.xpath(xpath)).getText();
        	  discount =xpath.substring(0,3);
        	  
        	 nlpResponseModel.setStatus(CommonConstants.pass);
        	 nlpResponseModel.setMessage("Sucessfully fetch the only Product Discount "+discount);
        	 
        	  
          }catch(Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.fail);
 			 nlpResponseModel.setMessage("Fail to fetch the Product Discount"+e);
          }

         
          nlpResponseModel.getAttributes().put("productdiscount", discount);
          return nlpResponseModel;
      }
  } 