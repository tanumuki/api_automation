package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import pojos.UpdatedLink.GetUpdatedLink;
import resources.Util;
import validators.UserGetUpdatedLinkValidator;
import validators.Validate;

@Slf4j
public class UserGetUpdatedLink extends Util {

    @And("I validate the response against the passed query parameter and userId {string}")
    public void iValidateTheResponseAgainstThePassedQueryParameter(String url_userid) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        GetUpdatedLink linkPojo = objectMapper.readValue(GenericSteps.resp.asString(), GetUpdatedLink.class);
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(linkPojo.getStatus().equalsIgnoreCase(Validate.API_STATUS_SUCCESS),
                "Expected \"" + Validate.API_STATUS_SUCCESS + "\", but found: \"" + linkPojo.getStatus() + "\"");
        new UserGetUpdatedLinkValidator().validate(linkPojo, sa, url_userid);
        sa.assertAll();

    }


}