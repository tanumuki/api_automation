package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.asserts.SoftAssert;
import resources.Util;
import validators.UserIsSame.UserisSameValidator;


public class UserIsSame extends Util {

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    private JsonNode map;

    @And("Clear Downloads pop up should be validated")
    public void Clear_Downloads_pop_up_should_be_validated() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        pojos.userIsSame.UserIsSameDetails userDetails = mapper.readValue(GenericSteps.resp.asString(), pojos.userIsSame.UserIsSameDetails.class);
        SoftAssert sa = new SoftAssert();
        new UserisSameValidator().validate(userDetails, sa);
        sa.assertAll();
    }

}
