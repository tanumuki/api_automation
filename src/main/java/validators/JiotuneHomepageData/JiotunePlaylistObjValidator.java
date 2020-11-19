package validators.JiotuneHomepageData;

import entities.Song;
import org.testng.asserts.SoftAssert;
import pojos.JiotuneHomePageData.JTPlaylistMoreInfo;
import pojos.JiotuneHomePageData.JiotuneHomePageData;
import pojos.JiotuneHomePageData.JiotunePlaylistObj;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.EntityValidator;
import validators.genericValidators.PlaylistValidator;
import validators.genericValidators.SongValidator;

public class JiotunePlaylistObjValidator extends EntityValidator {
    final String className = getClass().getName();

    public void validate(JiotunePlaylistObj pl, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        super.validate(pl, sa);

        new PlaylistValidator().validateMoreInfo(pl, sa);
        JTPlaylistMoreInfo mi = pl.getMoreInfo();
        if(Validate.isNonEmptyString(mi.getPrimaryArtists())){
            sa.assertTrue(Validate.asString(mi.getPrimaryArtists()), AssertionMsg.print(className, methodName, "primary_artists", mi.getPrimaryArtists()));
        }

        if(Validate.isNonEmptyString(mi.getSingers())){
            sa.assertTrue(Validate.asString(mi.getSingers()), AssertionMsg.print(className, methodName, "singers", mi.getSingers()));
        }

        if(mi.getCtr() != null){
            sa.assertTrue(Validate.asNum(mi.getCtr()), AssertionMsg.print(className, methodName, "ctr", String.valueOf(mi.getCtr())));
        }

        if(Validate.isNonEmptyString(mi.getVcode())){
            sa.assertTrue(Validate.asNum(mi.getVcode()), AssertionMsg.print(className, methodName, "vcode", mi.getVcode()));
        }

        if(Validate.isNonEmptyString(mi.getVlink())){
            sa.assertTrue(Validate.asExternalURL(mi.getVlink()), AssertionMsg.print(className, methodName, "vlink", mi.getVlink()));
        }

    }

}
