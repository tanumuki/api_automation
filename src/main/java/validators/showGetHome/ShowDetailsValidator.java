package validators.showGetHome;

import entities.ShowDetails;
import entities.ShowGetHome;
import org.testng.asserts.SoftAssert;
import validators.genericValidators.EntityValidator;

public class ShowDetailsValidator extends EntityValidator {

    public void validate(ShowGetHome showHome, SoftAssert sa) {
        ShowDetails showDetails = showHome.getShowDetails();
        super.validate(showDetails, sa, showDetails.getId(), "show");

        
    }

}
