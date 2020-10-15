package validators.browseGetAllValidator;

import entities.Mix;
import org.testng.asserts.SoftAssert;
import pojos.appGetLaunchData.Ads;
import pojos.browseGetAll.BrowseGetAllPojo;
import validators.AssertionMsg;
import validators.HomepageDataV2.HomepageDataValidator;
import validators.Validate;
import validators.appGetLaunchDataValidators.GetLaunchDataValidator;
import validators.genericValidators.MixValidator;
import validators.genericValidators.ModulesValidator;

public class BrowseGetAllValidator extends HomepageDataValidator {
    final String className = getClass().getName();

    public void validate(BrowseGetAllPojo bg, SoftAssert sa) {
        //Validate modules
        new ModulesValidator().validate(bg.getModules().getMadeForYou(), sa);

        //Validate Made for you mixes
        for(Mix mix : bg.getMadeForYou()){
            new MixValidator().validate(mix, sa);
        }
    }
}
