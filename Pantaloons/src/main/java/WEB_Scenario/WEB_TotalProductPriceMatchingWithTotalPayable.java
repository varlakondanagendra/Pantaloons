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
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component("LIC1710_PJT1013_PE_NLP85ac4da5-9929-4412-83ea-f2cfd3f95520")
public class WEB_TotalProductPriceMatchingWithTotalPayable implements Nlp {
	int priceTotal=0;
    @InputParams({@InputParam(name = "priceValue", type = "java.lang.String"),
    	@InputParam(name = "shippingCharge", type = "java.lang.String"),
    	@InputParam(name = "totalPayableAmount", type = "java.lang.String"),
    	@InputParam(name = "indexValue", type = "java.lang.Integer")})
    @ReturnType(name = "priceTotal", type = "java.lang.Integer")

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
          String PriceValue = (String) attributes.get("priceValue");
          String shippingCharge = (String) attributes.get("shippingCharge");
          String totalPayableAmount = (String) attributes.get("totalPayableAmount");
         Integer indexValue=(Integer) attributes.get("indexValue");
          
      
          try {
        	  WebDriver driver=(WebDriver)nlpRequestModel.getDriver().getSpecificIDriver();
        	  List<WebElement> list=driver.findElements(By.xpath(PriceValue));
        	 for(WebElement text:list) {
        		 String name=text.getText();
        		 String[] na=name.split(" ");
        		 String tx=na[indexValue];
        		 int price=Integer.parseInt(tx);
        		 priceTotal=priceTotal+price;
        	 }
        	 WebElement charge=driver.findElement(By.xpath(shippingCharge));
        	 String free=charge.getText();
        	 if(priceTotal<=1000) {
        		 priceTotal=priceTotal+100;
        		 nlpResponseModel.setStatus(CommonConstants.pass);
        		 nlpResponseModel.setMessage("Total payable amount is "+priceTotal);
        	 }
        	 else {
        		 if(priceTotal>1000 && free.contains("FREE")) {
        			 WebElement amount=driver.findElement(By.xpath(totalPayableAmount));
        			 String amt=amount.getText();
        			 String s=amt.replaceAll("[(^()? ]", "");
        			 double d=Double.parseDouble(s);
        			 int i=(int) d;
        			 if(i==priceTotal) {
        				 nlpResponseModel.setStatus(CommonConstants.pass);
                		 nlpResponseModel.setMessage("Total payable amount is matching with total product price and value is"+i);
        			 }
        			 else {
        				 nlpResponseModel.setStatus(CommonConstants.fail);
                		 nlpResponseModel.setMessage("Total payable amount is not matching with "+priceTotal);
        			 }
        		 }
        	 }
        	 
        	  
          }catch(Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.fail);
 			 nlpResponseModel.setMessage("Fail to get the price of the product"+e);
          }

         
          nlpResponseModel.getAttributes().put("priceTotal", priceTotal);
          return nlpResponseModel;
      }
  } 