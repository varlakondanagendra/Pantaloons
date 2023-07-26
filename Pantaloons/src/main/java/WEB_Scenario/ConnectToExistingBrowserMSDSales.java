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

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Component;

@Component("LIC1710_PJT1013_PE_NLP6e9362c2-f131-44f8-89b8-07fbb9f9d34f")
public class ConnectToExistingBrowserMSDSales implements Nlp {
	@InputParams({@InputParam(name = "Desired Capabilities", type = "openqa.selenium.remote.DesiredCapabilities"),
		@InputParam(name = "Port", type = "java.lang.Integer")})
	@ReturnType(name = "BrowserCapablity", type = "openqa.selenium.remote.DesiredCapabilities")


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
          DesiredCapabilities cap = (DesiredCapabilities) attributes.get("Desired Capabilities");
          try {
              Integer port = (Integer) attributes.get("Port");
              ChromeOptions options = new ChromeOptions();
  			options.setExperimentalOption("debuggerAddress", "localhost:"+port+" ");
  			cap.merge(options);
  			nlpResponseModel.setStatus(CommonConstants.pass);
  			nlpResponseModel.setMessage("Browser is Launched Successfully");
        	Thread.sleep(2000);
        	Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
        	Runtime.getRuntime().exec("taskkill /F /FI \"WINDOWTITLE eq Terminal\"");
        		
      		nlpResponseModel.setStatus(CommonConstants.pass);
  			nlpResponseModel.setMessage("Browser got launched successfully");
          }
          catch(Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.fail);
    		  nlpResponseModel.setMessage("Failed to launch the browser because " + e);
          }
          // Your program element business logic goes here ...
          nlpResponseModel.setDesiredCapabilities(cap);
  		  nlpResponseModel.getAttributes().put("BrowserCapablity", cap);
          return nlpResponseModel;
      }
  } 
