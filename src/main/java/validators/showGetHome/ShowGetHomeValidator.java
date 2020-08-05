package validators.showGetHome;

import entities.Episode;
import entities.Season;
import entities.ShowGetHome;
import org.testng.asserts.SoftAssert;

public class ShowGetHomeValidator {

    public void validate(ShowGetHome showHome, SoftAssert sa) {
        new ShowDetailsValidator().validate(showHome, sa);
        for(Season season : showHome.getSeasons()) {
            new SeasonValidator().validate(season, sa, season.getId(), "season");
        }

        for(Episode episode : showHome.getEpisodes()) {

        }
    }

}
