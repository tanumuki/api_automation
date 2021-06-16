package validators;

import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import pojos.JioSendOtp.JioSendOtpPojo;

@Slf4j
public class JioSendOtpValidator {
    String className = getClass().getSimpleName();

    public void validate(JioSendOtpPojo jioSendOtpPojo, SoftAssert sa) {
        String status = jioSendOtpPojo.getStatus();
        sa.assertTrue(Validate.asJioOTPStatus(status), className + "." + "validate status failed");
        log.info("LOG response status in jio send otp API is " + status);

        if (status.equalsIgnoreCase("success")) {
            String correlation_id = jioSendOtpPojo.getData().getCorrelation_id();
            sa.assertTrue(Validate.asCorrelationId(correlation_id), className + "." + "validate correlation id failed");
            log.info("LOG response status in jio send otp API is " + correlation_id);
        } else if (status.equalsIgnoreCase("error")) {
            String msg = jioSendOtpPojo.getMsg();
            sa.assertTrue(msg.equalsIgnoreCase("Your OTP could not be sent because there were too many unverified requests. Please try again later.") || msg.equalsIgnoreCase("Request is missing required parameters or parameters are not valid"), className + "." + "validate msg failed");
            log.info("LOG response msg in jio send otp API is " + msg);
        }
    }

}
