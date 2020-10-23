package validators.genericValidators;

import entities.ShowMini;
import org.testng.asserts.SoftAssert;
import validators.Artist.ArtistPageValidator;
import validators.AssertionMsg;
import validators.Validate;
import validators.showGetHome.ShowDetailsValidator;

public class ShowMiniValidator extends EntityValidator{
    final String className = getClass().getName();

    public void validate(ShowMini sm, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        super.validate(sm, sa);

        if(sm.getSeasonNumber() != null) {
            sa.assertTrue(Validate.asNum(sm.getSeasonNumber()), AssertionMsg.print(className, methodName, "show_mini.season_number", String.valueOf(sm.getSeasonNumber())));
        }

        //TODO: Artists, primary & featured artists validations

        if(sm.getMoreInfo() != null) {
            new ShowDetailsValidator().validateMoreInfo(sm.getMoreInfo(), sa, sm.getId());
        }
    }
}
