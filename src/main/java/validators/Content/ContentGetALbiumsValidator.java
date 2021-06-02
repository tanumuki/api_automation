package validators.Content;

import entities.Album;
import entities.AlbumData;
import org.testng.asserts.SoftAssert;
import validators.Validate;
import validators.genericValidators.AlbumValidator;

public class ContentGetALbiumsValidator {
    final String className = getClass().getName();

    public void validate(AlbumData ad, SoftAssert sa)
    {
        for(Album album : ad.getAlbumList()){
            new AlbumValidator().validate(album, sa);
        }

        sa.assertTrue(Validate.asNum(ad.getCount()),className + "." + "validate count failed");
        sa.assertTrue(Validate.asBoolean(ad.getLast_page()),className + "." + "validate last_page failed");
    }
}
