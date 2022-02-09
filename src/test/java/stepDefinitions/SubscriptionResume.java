package stepDefinitions;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import org.testng.asserts.SoftAssert;
import resources.Util;
import validators.SubscriptionResume.SubscriptionResumeValidator;


public class SubscriptionResume extends Util {

    @And("Subscription Resume API response must be validated successfully")
    public void Subscription_Resume_API_response_must_be_validated_successfully() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        pojos.SubscriptionResumeAPI.subscriptionResume subDetails = mapper.readValue(GenericSteps.resp.asString(), pojos.SubscriptionResumeAPI.subscriptionResume.class);
        SoftAssert sa = new SoftAssert();
        new SubscriptionResumeValidator().validate(subDetails, sa);
        sa.assertAll();
    }

    }

