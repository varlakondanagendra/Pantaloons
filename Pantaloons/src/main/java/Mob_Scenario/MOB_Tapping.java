package Mob_Scenario;

	  import com.tyss.optimize.common.util.CommonConstants;
      import com.tyss.optimize.nlp.util.Nlp;
	  import com.tyss.optimize.nlp.util.NlpException;
	  import com.tyss.optimize.nlp.util.NlpRequestModel;
	  import com.tyss.optimize.nlp.util.NlpResponseModel;
	  import com.tyss.optimize.nlp.util.annotation.InputParam;
	  import com.tyss.optimize.nlp.util.annotation.InputParams;
	  import java.util.Map;
	  import java.util.ArrayList;
	  import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
	  import org.springframework.stereotype.Component;
	  	
	  
	   @Component("LIC1710_PJT1013_PE_NLP94960029-3254-4705-afc7-8dd9a08f082c")
	  public class MOB_Tapping implements Nlp {
	        @InputParams({@InputParam(name = "elementName", type = "java.lang.String"), 
	      @InputParam(name = "elementType", type = "java.lang.String"), 
	      @InputParam(name = "element", type = "org.openqa.selenium.WebElement"),
	      @InputParam(name = "Count", type = "java.lang.Integer")})
	      

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
	         Integer count = (Integer) attributes.get("Count");
              WebElement element = (WebElement)attributes.get("element");
      
	          try {
	        	  for(int i=1;i<=count;i++) {  
	    	          element.click();
	    	          Thread.sleep(2000);
	    	          }
	        	  nlpResponseModel.setStatus(CommonConstants.pass);
	    	       nlpResponseModel.setMessage("Successfully Tapped On Element");
	    	        
	             }
	          catch(NoSuchElementException e) {
	        	  nlpResponseModel.setStatus(CommonConstants.fail);
	        	  nlpResponseModel.setMessage("Failed To Locate The Element");
	        	  
	          }
	          catch(Exception e){
	        	  nlpResponseModel.setStatus(CommonConstants.fail);
	        	  nlpResponseModel.setMessage("Failed To Tap On Element");
	         
	          }
	          return nlpResponseModel;
	      }
	  } 
	


