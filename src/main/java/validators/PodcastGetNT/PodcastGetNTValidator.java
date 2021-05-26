package validators.PodcastGetNT;

import entities.ShowDetails;
import org.testng.asserts.SoftAssert;
import pojos.podcastGetNT.PodcastGetNT;
import pojos.podcastGetNT.PodcastIDClass;
import pojos.podcastGetNT.PodcastNTMoreInfo;
import pojos.podcastGetNT.PodcastNTObj;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.ArtistMapValidator;
import validators.genericValidators.EntityValidator;
import validators.showGetHome.ShowDetailsValidator;

public class PodcastGetNTValidator extends EntityValidator {
    final String className = getClass().getName();

    public void validate(PodcastGetNT nt, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        if(nt != null) {
            for(PodcastNTObj show : nt.getData()) {
                validatePodcastNTObj(show, sa);
            }
            if(nt.getLastPage() != null){
                sa.assertTrue(Validate.asBoolean(nt.getLastPage()), AssertionMsg.print(className, methodName, "last_page", String.valueOf(nt.getLastPage())));
            }
        }
    }

    void validatePodcastNTObj(PodcastNTObj nto, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        super.validate(nto, sa);

        validateMoreInfo(nto.getMoreInfo(), sa, nto.getId());
    }

    void validateMoreInfo(PodcastNTMoreInfo mi, SoftAssert sa, String id) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        new ShowDetailsValidator().validateMoreInfo(mi, sa, id);

        validatePodcastIDClass(mi.get_id(), sa);

        if(Validate.isNonEmptyString(mi.getCopyrightText())){
            sa.assertTrue(Validate.asString(mi.getCopyrightText()), AssertionMsg.print(className, methodName, "show.more_info.copyright_text", mi.getCopyrightText()));
        }

        if(Validate.isNonEmptyString(mi.getM4a())) {
            sa.assertTrue(Validate.asBoolean(mi.getM4a()),
                    AssertionMsg.print(className, methodName, "show.more_info.m4a", mi.getM4a()));
        }

        new ArtistMapValidator().validate(mi.getArtist_map(), sa, "show", id);
    }

    void validatePodcastIDClass(PodcastIDClass idc, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        if(Validate.isNonEmptyString(idc.getOid())){
            sa.assertTrue(Validate.asString(idc.getOid()), AssertionMsg.print(className, methodName, "show._id.$oid", idc.getOid()));
        }
    }
}
