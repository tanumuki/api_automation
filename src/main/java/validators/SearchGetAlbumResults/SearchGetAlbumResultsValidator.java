package validators.SearchGetAlbumResults;

import entities.Album;
import org.testng.asserts.SoftAssert;
import pojos.SearchGetAlbumResults.SearchGetAlbumResults;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.AlbumValidator;

public class SearchGetAlbumResultsValidator {
    final String className = getClass().getName();

    public void validate(SearchGetAlbumResults ar, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        if(ar.getTotal() != null){
            sa.assertTrue(Validate.asNum(ar.getTotal()), AssertionMsg.print(className, methodName, "total", ar.getTotal().toString()));
        }else{
            sa.fail("Search Get Album Results total count is null");
        }

        if(ar.getStart() != null){
            sa.assertTrue(Validate.asNum(ar.getStart()), AssertionMsg.print(className, methodName, "start", ar.getStart().toString()));
        }else{
            sa.fail("Search Get Album Results start count is null");
        }

        sa.assertTrue(ar.getStart() <= ar.getTotal(), "Start > Total for Jiotunes get more songs");

        for(Album album : ar.getResults()) {
            new AlbumValidator().validate(album, sa);
        }
    }
}
