package validators;

import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import pojos.contentGetTopSearches.ContentGetTopSearchesPojo;

@Slf4j
public class ContentGetTopSearchesValidator {
    final String className = ContentGetTopSearchesValidator.class.getName();

    public void validate(ContentGetTopSearchesPojo contentGetTopSearchesPojo, SoftAssert sa) {
        String entity_id = contentGetTopSearchesPojo.getEntity_id();
        sa.assertTrue(Validate.asAlphaNumericWithUnderscoreHyphen(entity_id), className + "." + "validate entity id failed");
        log.info("LOG response entity id is " + entity_id);

        String image = contentGetTopSearchesPojo.getImage();
        sa.assertTrue(Validate.asCDNURL(image), className + "." + "validate image failed");
        log.info("LOG response image is " + image);

        String entity_name = contentGetTopSearchesPojo.getEntity_name();
        sa.assertTrue(Validate.asString(entity_name), className + "." + "validate entity name failed");
        log.info("LOG response image is " + entity_name);

        String entity_type = contentGetTopSearchesPojo.getEntity_type();
        sa.assertTrue(Validate.asString(entity_type), className + "." + "validate entity type failed");
        log.info("LOG response image is " + entity_type);

    }
}