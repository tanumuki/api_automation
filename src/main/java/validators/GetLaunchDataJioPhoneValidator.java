package validators;

import io.cucumber.messages.internal.com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import pojos.jioPhoneGetLaunchData.HomepageData;
import pojos.jioPhoneGetLaunchData.JioPhoneGetLaunchData;

@Slf4j
public class GetLaunchDataJioPhoneValidator {
    String className = getClass().getName();

    public void validate(JioPhoneGetLaunchData jioPhoneGetLaunchData, SoftAssert sa) {
        int i = 1;
        JsonObject config = jioPhoneGetLaunchData.getConfig();
        //TODO: @tanu Please recheck the validation for config object
        sa.assertTrue(config.size()>0, className + "." + "validate config failed for entity");
        log.info(("LOG response config in JioPhone get launch API is: " + config));

        for (HomepageData homepageData : jioPhoneGetLaunchData.getHomepageData()) {
            String id = homepageData.getId();
            sa.assertTrue(Validate.asString(id), className + "." + "validate id failed for entity - " + i);
            log.info(("LOG response id for the entity" + i + " in JioPhone get launch API is: " + id));

            String type = homepageData.getType();
            sa.assertTrue(Validate.asString(type), className + "." + "validate type failed for entity - " + i);
            log.info(("LOG response type for the entity" + i + " in JioPhone get launch API is: " + type));

            String title = homepageData.getTitle();
            sa.assertTrue(Validate.asString(title), className + "." + "validate title failed for entity - " + i);
            log.info(("LOG response title for the entity" + i + " in JioPhone get launch API is: " + title));

            String viewType = homepageData.getViewtype();
            sa.assertTrue(Validate.asViewType(viewType), className + "." + "validate title failed for entity - " + i);
            log.info(("LOG response title for the entity" + i + " in JioPhone get launch API is: " + title));

            String article = homepageData.getStyles().getArticle();
            sa.assertTrue(Validate.asString(article), className + "." + "validate article failed for entity - " + i);
            log.info(("LOG response article for the entity" + i + " in JioPhone get launch API is: " + article));

            String span = homepageData.getStyles().getSpan();
            sa.assertTrue(Validate.asString(span), className + "." + "validate span failed for entity - " + i);
            log.info(("LOG response span for the entity" + i + " in JioPhone get launch API is: " + span));

            String api = homepageData.getAction().getApi();
            sa.assertTrue(Validate.asAPIJioPhoneGetLaunchData(api), className + "." + "validate api failed for entity - " + i);
            log.info(("LOG response api for the entity" + i + " in JioPhone get launch API is: " + api));

            String page = homepageData.getAction().getPagination().getPage();
            sa.assertTrue(page.equals("p"), className + "." + "validate page failed for entity - " + i);
            log.info(("LOG response page for the entity" + i + " in JioPhone get launch API is: " + page));

            String count = homepageData.getAction().getPagination().getCount();
            sa.assertTrue(count.equals("n"), className + "." + "validate count failed for entity - " + i);
            log.info(("LOG response count for the entity" + i + " in JioPhone get launch API is: " + count));

            String default_count = homepageData.getAction().getPagination().getDefault_count();
            sa.assertTrue(Validate.asNum(default_count), className + "." + "validate default_count failed for entity - " + i);
            log.info(("LOG response default_count for the entity" + i + " in JioPhone get launch API is: " + default_count));

            Integer position = homepageData.getPosition();
            sa.assertTrue(Validate.asNum(position), className + "." + "validate position failed for entity - " + i);
            log.info(("LOG response position for the entity" + i + " in JioPhone get launch API is: " + default_count));

            i += 1;
        }
    }
}