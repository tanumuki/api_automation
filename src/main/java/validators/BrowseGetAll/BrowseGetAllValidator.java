package validators.BrowseGetAll;

import entities.Mix;
import org.testng.asserts.SoftAssert;
import pojos.browseGetAll.BrowseGetAllPojo;
import validators.HomepageDataV2.HomepageDataValidator;
import validators.genericValidators.MixValidator;
import validators.genericValidators.ModulesDataValidator;

public class BrowseGetAllValidator extends HomepageDataValidator {
    final String className = getClass().getName();

    public void validate(BrowseGetAllPojo bg, SoftAssert sa) {
        //Validate modules
        new ModulesDataValidator().validate(bg.getModules().getMadeForYou(), sa);

        //Validate Made for you mixes
        for(Mix mix : bg.getMadeForYou()){
            new MixValidator().validate(mix, sa);
        }
    }
}
