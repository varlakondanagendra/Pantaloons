
  package Mob_Scenario;

  import com.tyss.optimize.nlp.util.Nlp;
  import com.tyss.optimize.nlp.util.NlpException;
  import com.tyss.optimize.nlp.util.NlpRequestModel;
  import com.tyss.optimize.nlp.util.NlpResponseModel;
  import com.tyss.optimize.nlp.util.annotation.InputParam;
  import com.tyss.optimize.nlp.util.annotation.InputParams;
  
  import com.tyss.optimize.nlp.util.annotation.ReturnType;
  import com.tyss.optimize.common.util.CommonConstants;
  import org.springframework.stereotype.Component;
  import org.openqa.selenium.WebElement;
  import java.util.ArrayList;
  import java.util.Map;
  import java.util.List;


  @Component("LIC1710_PJT1013_PE_NLP2ccf95d8-ae1c-4c79-b11b-a01e88eacd39")
public class MOB_ValidateIfElementIsNotEnabled implements Nlp {
      @InputParams({@InputParam(name = "elementName", type = "java.lang.String"),
                    @InputParam(name = "elementType", type = "java.lang.String"),
                    @InputParam(name = "element", type = "org.openqa.selenium.WebElement")})
      @ReturnType(name = "isNotEnabled", type = "java.lang.Boolean")

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
          WebElement element = (WebElement) attributes.get("element");
          boolean isNotEnabled = false;
          try {
        	  isNotEnabled = element.isEnabled();
              if (!isNotEnabled) {
                    nlpResponseModel.setStatus(CommonConstants.pass);
                    nlpResponseModel.setMessage("Element is not Enabled");
              }
              else{
                    nlpResponseModel.setStatus(CommonConstants.fail);
                    nlpResponseModel.setMessage("Element is Enabled");
              }
          } catch(Exception e) {
                    nlpResponseModel.setStatus(CommonConstants.fail);
                    nlpResponseModel.setMessage("Failed to check if eleement is not Enabled");
          }


          nlpResponseModel.getAttributes().put("isNotEnabled", isNotEnabled);
          return nlpResponseModel;
      }
  } 