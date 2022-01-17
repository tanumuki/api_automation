package stepDefinitions;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import pojos.content.HandleUnsupportedDeeplink;
import resources.Util;
import validators.Content.HandleUnsupportedDeeplinkValidator;



@Slf4j

public class ContentHandleUnsupportedDeeplink extends Util {
      Response resp;


    @And("Content handle unsupported deeplink api response must be validated successfully")
    public void content_handle_unsupported_deeplink_api_response_must_be_validated_successfully() throws JsonProcessingException {
        System.out.println("Response OK "+ GenericSteps.resp.asString());
        SoftAssert sa = new SoftAssert();
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        HandleUnsupportedDeeplink unsupportedDeeplink = mapper.readValue(GenericSteps.resp.asString(), HandleUnsupportedDeeplink.class);
        new HandleUnsupportedDeeplinkValidator().validateHandleUnsupportedDeeplinkData(unsupportedDeeplink, sa);
        log.info("Validation done for unsupported deeplink status is  " +  unsupportedDeeplink.getStatus() );
        log.info("Validation done for unsupported deeplink data  is  " +  unsupportedDeeplink.getData());


    }

}

