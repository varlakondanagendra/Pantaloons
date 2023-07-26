
package WEB_Scenario;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Component;
@Slf4j
@Component("LIC1710_PJT1013_PE_NLPe12c5233-a0b9-4d52-8284-8761e09d3e9e")
public class LaunchBrowserWithExistingDirectoryMSDSales implements Nlp {
    @InputParams({@InputParam(name = "Directory", type = "java.lang.String"), 
    	@InputParam(name = "Port", type = "java.lang.Integer")})

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
        	//  log.info("Entered Try Block");
        	  String dir = (String) attributes.get("Directory");
              Integer port = (Integer) attributes.get("Port");
        	  String cmdCommand = "chrome.exe -remote-debugging-port="+ port +" --no-first-run --no-default-browser-check --user-data-dir="+dir;
        	  String chromePath = "C:\\Program Files\\Google\\Chrome\\Application";
        	 // log.info("Started Executing Command");
        	  Thread.sleep(5000);
        	  Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + cmdCommand, null, new File(chromePath));
        	 // log.info("Command Executed");
        	  Thread.sleep(2000);
        		
      		nlpResponseModel.setStatus(CommonConstants.pass);
  			nlpResponseModel.setMessage("Browser got launched successfully");
          }
          catch(Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.fail);
    			nlpResponseModel.setMessage("Failed to launch the browser because " + e);
          }
          // Your program element business logic goes here ...

          return nlpResponseModel;
      }
//      public static void main(String[] args) throws NlpException {
//    	  LaunchBrowserWithExistingDirectory ld= new LaunchBrowserWithExistingDirectory();
//    	  NlpRequestModel nl=new NlpRequestModel();
//    	  Map<String, Object> attributes = nl.getAttributes();
//    	  attributes.put("Directory", "C:\\ChromeDataForMSD");
//    	  attributes.put("Port", 9292);
//    	  ld.execute(nl);
//	}
	}

