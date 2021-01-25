package validators.genericValidators;

import org.testng.asserts.SoftAssert;
import pojos.SearchGetEntityResults.ArtistResultObj;
import validators.AssertionMsg;
import validators.Validate;

public class ArtistResultObjValidator {
    final String className = getClass().getName();

    public void validate(ArtistResultObj ao, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        sa.assertTrue(Validate.asId(ao.getArtists_id()), AssertionMsg.print(className, methodName, "artist.id", ao.getArtists_id()));

        sa.assertTrue(Validate.asString(ao.getArtists_name()), AssertionMsg.print(className, methodName, "artist.name", ao.getArtists_name()));

        sa.assertTrue(Validate.asNum(ao.getArtists_sequence()), AssertionMsg.print(className, methodName, "artist.sequence", ao.getArtists_sequence()));

        sa.assertTrue(Validate.asArtistType(ao.getArtists_role()), AssertionMsg.print(className, methodName, "artist.role", ao.getArtists_role()));
    }
}
