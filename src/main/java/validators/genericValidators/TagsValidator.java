package validators.genericValidators;

import entities.Tags;
import org.testng.asserts.SoftAssert;
import validators.AssertionMsg;
import validators.Validate;

public class TagsValidator {
    final String className = getClass().getName();
    public void validate(Tags tags, SoftAssert sa, String entityType, String entityId) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        if(tags.getGenre() != null){
            for(String genre : tags.getGenre()) {
                sa.assertTrue(Validate.asString(genre), AssertionMsg.print(className, methodName, entityType, "more_info.tags.genre", genre, entityId));
            }
        }

        if(tags.getMood() != null) {
            for(String mood : tags.getMood()) {
                sa.assertTrue(Validate.asString(mood), AssertionMsg.print(className, methodName, entityType, "more_info.tags.mood", mood, entityId));
            }
        }

        if(tags.getSituation() != null) {
            for(String situation : tags.getMood()) {
                sa.assertTrue(Validate.asString(situation), AssertionMsg.print(className, methodName, entityType, "more_info.tags.situation", situation, entityId));
            }
        }

        if(tags.getSeasonality() != null) {
            for(String seasonality : tags.getMood()) {
                sa.assertTrue(Validate.asString(seasonality), AssertionMsg.print(className, methodName, entityType, "more_info.tags.seasonality", seasonality, entityId));
            }
        }
    }
}
