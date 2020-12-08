package validators.JiotuneHomepageData;

import entities.Song;
import org.testng.asserts.SoftAssert;
import pojos.JiotuneHomePageData.JTPlaylistEmptyMI;
import pojos.JiotuneHomePageData.JiotuneHomePageData;
import validators.genericValidators.SongValidator;

public class JTPlaylistEmptyMIValidator {
    final String className = getClass().getName();

    public void validate(JTPlaylistEmptyMI mi, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        //TODO: This has to be fixed from the BE. This is a temporary placeholder method

    }
}
