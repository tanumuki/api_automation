package validators;

import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import pojos.MatchingMatch.MatchingMatchData;
import pojos.MatchingMatch.MatchingMatchPojo;

import java.util.Map;

@Slf4j
public class MatchingMatchValidator {
    String className = this.getClass().getSimpleName();

    public void validate(MatchingMatchPojo matchingMatchPojo, SoftAssert sa, String entityType) {
        for (Map.Entry<String, MatchingMatchData[]> data : matchingMatchPojo.getEntityType().entrySet()) {
            String entity = data.getKey();
            sa.assertEquals(entity, entityType, className + ": validate entity type failed");
            log.info(className + ": LOG response entity type in Matching match API for " + entityType + " is " + entity);

            for (MatchingMatchData matchingMatchData : data.getValue()) {
                String id = matchingMatchData.getId();
                sa.assertTrue(Validate.asString(id), className + ": validate id for entity " + entityType + " failed");
                log.info(className + ": LOG response id in Matching match API for " + entityType + " is " + id);

                if (matchingMatchData.getLanguage() != null) {
                    String language = matchingMatchData.getLanguage();
                    sa.assertTrue(Validate.asString(language), className + ": validate language for entity " + entityType + " failed");
                    log.info(className + ": LOG response language in Matching match API for " + entityType + " is " + language);
                }

                String url = matchingMatchData.getUrl();
                sa.assertTrue(Validate.asPermaURL(url), className + ": validate url for entity " + entityType + " failed");
                log.info(className + ": LOG response url in Matching match API for " + entityType + " is " + url);

                String deeplink = matchingMatchData.getDeeplink();
                sa.assertTrue(Validate.asMatchingMatchDeeplink(deeplink), className + ": validate deeplink for entity " + entityType + " failed");
                log.info(className + ": LOG response deeplink in Matching match API for " + entityType + " is " + deeplink);

            }
        }
    }
}
