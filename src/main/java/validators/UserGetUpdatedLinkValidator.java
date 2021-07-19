package validators;

import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import pojos.UpdatedLink.GetUpdatedLink;

/**
 * @author snigdhamajee
 *
 */

@Slf4j
public class UserGetUpdatedLinkValidator {

    String className = getClass().getName();

    public void validate(GetUpdatedLink linkPojo, SoftAssert sa, String url) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        if (linkPojo.getData() != null) {
            String urlFromResp = linkPojo.getData().getUrl();
            sa.assertTrue(Validate.asUpdatedUrlForDeeplink(urlFromResp, url), AssertionMsg.print(className, methodName, "data.url", url));
            log.info("The url from response "+ urlFromResp + " is validated");
        }
        else {
            sa.fail("The Data object is empty.");
        }
    }
}
