package validators;

import entities.Song;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import pojos.searchGetResultsFromEntities.SearchGetResultsFromEntities;
import validators.genericValidators.EntityValidator;
import validators.genericValidators.SongValidator;

@Slf4j
public class SearchGetResultsFromEntitiesValidator extends EntityValidator {
    final String className = SongValidator.class.getName();


    public void validate(SearchGetResultsFromEntities searchGetResultsFromEntities, SoftAssert sa) {
        int total = searchGetResultsFromEntities.getTotal();
        sa.assertTrue(Validate.asNum(total), className + "." + "validate total failed");
        log.info("LOG response total is " + total);

        int start  = searchGetResultsFromEntities.getStart();
        sa.assertTrue(Validate.asNum(start), className + "." + "validate start failed");
        log.info("LOG response start is " + start);

        for(Song songs : searchGetResultsFromEntities.getResults())
        {
            new SongValidator().validate(songs,sa);
        }
    }
}
