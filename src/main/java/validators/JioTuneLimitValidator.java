package validators;

import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import pojos.JioTuneLimitPojo;

@Slf4j
public class JioTuneLimitValidator {
    String className = getClass().getSimpleName();
    public void validate(JioTuneLimitPojo jioTuneLimitPojo, SoftAssert sa) {
        String available = jioTuneLimitPojo.getAvailable();
        sa.assertTrue(Validate.asBoolean(available), className + "." + "validate available failed");
        log.info("LOG response available in jio tune limit API is " + available);

        int left = jioTuneLimitPojo.getLeft();
        sa.assertTrue(Validate.asNum(left), className + "." + "validate left failed");
        log.info("LOG response left in jio tune limit API is " + left);

        int total = jioTuneLimitPojo.getTotal();
        sa.assertTrue(Validate.asNum(total), className + "." + "validate total failed");
        log.info("LOG response total in jio tune limit API is " + total);

        sa.assertTrue(left<=total, className+"."+ " number of left jiotunes is greater than the total available");
    }
}
