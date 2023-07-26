package Mob_web_Scenario;

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


@Component("LIC1710_PJT1013_PE_NLP695b24a6-eb79-421f-b615-dc27db1e1adc")
public class MOB_GetTitleOfBanner implements Nlp {
	
    @InputParams({@InputParam(name = "bannerTitle", type = "java.lang.String")})
    @ReturnType(name = "titleOfBanner", type = "java.lang.String")

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
          String titleOfBanner=null;
          
      
          try {
        	  String bannerTitle = (String) attributes.get("bannerTitle");
              String []a=bannerTitle.split(" ");
        	  titleOfBanner=titleOfBanner+a[1];
        	  
        	 nlpResponseModel.setStatus(CommonConstants.pass);
        	 nlpResponseModel.setMessage("Title of the Banner"+titleOfBanner);
        	 
        	  
          }catch(Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.fail);
 			 nlpResponseModel.setMessage("Fail to get the Title of the Banner"+e);
          }

         
          nlpResponseModel.getAttributes().put("title of the Banner", titleOfBanner);
          return nlpResponseModel;
      }
  } 