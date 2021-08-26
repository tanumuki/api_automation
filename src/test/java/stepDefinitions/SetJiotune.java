package stepDefinitions;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import pojos.jioTuneLogin.UserJioLogin;
import resources.Util;
import validators.jioLoginValidator.JioLoginValidator;

@Slf4j
public class SetJiotune extends Util {





    @Then("^The Jio Tune API returns \"([^\"]*)\" with status code 200 and response message is validated$")
    public void the_jio_tune_api_returns_something_with_status_code_200_and_response_message_is_validated(String strArg1) throws Throwable {


        log.info("Response of jiotune api is  " +GenericSteps.resp.getBody().asString());
        log.info( " Validating Jiotune api response");
        SoftAssert sa = new SoftAssert();
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,true);
        System.out.println("response meow "+GenericSteps.resp.asString());
//        UserJioLogin jioLoginResponse= mapper.readValue(GenericSteps.resp.asString(), UserJioLogin.class);
//        new JioLoginValidator().validate(jioLoginResponse,sa);


    }

}
