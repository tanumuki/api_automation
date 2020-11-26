package validators;

import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import pojos.jioPhoneGetLaunchData.ConfigData;
import pojos.jioPhoneGetLaunchData.JioPhoneGetLaunchData;

@Slf4j
public class GetLaunchDataJioPhoneValidator {
    String className = getClass().getName();

    public void validate(JioPhoneGetLaunchData jioPhoneGetLaunchData, SoftAssert sa) {
        int i=1;
        for (ConfigData configData:jioPhoneGetLaunchData.getConfigData()) {
            String id = configData.getId();
            sa.assertTrue(Validate.asString(id), className + "." + "validate id failed for entity - "+i);
            log.info(("LOG response id for the entity" + i + " in JioPhone get launch API is: " + id));

            String type = configData.getType();
            sa.assertTrue(Validate.asString(type), className + "." + "validate type failed for entity - "+i);
            log.info(("LOG response type for the entity" + i + " in JioPhone get launch API is: " + type));

            String title = configData.getTitle();
            sa.assertTrue(Validate.asString(title), className + "." + "validate title failed for entity - "+i);
            log.info(("LOG response title for the entity" + i + " in JioPhone get launch API is: " + title));

            String viewType = configData.getViewtype();
            sa.assertTrue(Validate.asViewType(viewType), className + "." + "validate title failed for entity - "+i);
            log.info(("LOG response title for the entity" + i + " in JioPhone get launch API is: " + title));

            String article = configData.getStyles().getArticle();
            sa.assertTrue(Validate.asString(article), className + "." + "validate article failed for entity - "+i);
            log.info(("LOG response article for the entity" + i + " in JioPhone get launch API is: " + article));

            String span = configData.getStyles().getSpan();
            sa.assertTrue(Validate.asString(span), className + "." + "validate span failed for entity - "+i);
            log.info(("LOG response span for the entity" + i + " in JioPhone get launch API is: " + span));

            String api = configData.getAction().getApi();
            sa.assertTrue(Validate.asAPIJioPhoneGetLaunchData(api), className + "." + "validate api failed for entity - "+i);
            log.info(("LOG response api for the entity" + i + " in JioPhone get launch API is: " + api));

            String page = configData.getAction().getPagination().getPage();
            sa.assertTrue(page.equals("p"), className + "." + "validate page failed for entity - "+i);
            log.info(("LOG response page for the entity" + i + " in JioPhone get launch API is: " + page));

            String count = configData.getAction().getPagination().getCount();
            sa.assertTrue(count.equals("n"), className + "." + "validate count failed for entity - "+i);
            log.info(("LOG response count for the entity" + i + " in JioPhone get launch API is: " + count));

            String default_count = configData.getAction().getPagination().getDefault_count();
            sa.assertTrue(Validate.asNum(default_count), className + "." + "validate default_count failed for entity - "+i);
            log.info(("LOG response default_count for the entity" + i + " in JioPhone get launch API is: " + default_count));

            i+=1;
        }
    }
}