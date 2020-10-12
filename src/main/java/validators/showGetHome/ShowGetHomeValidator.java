package validators.showGetHome;

import entities.Episode;
import entities.Season;
import entities.ShowGetHome;
import org.testng.asserts.SoftAssert;
import validators.genericValidators.EpisodeValidator;
import validators.genericValidators.ModulesValidator;

public class ShowGetHomeValidator {
    final String className = getClass().getName();
    public void validate(ShowGetHome showHome, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        new ShowDetailsValidator().validate(showHome, sa);
        for(Season season : showHome.getSeasons()) {
            new SeasonValidator().validate(season, sa, season.getId(), "season");
        }

        for(Episode episode : showHome.getEpisodes()) {
            new EpisodeValidator().validate(episode, sa);
        }

        new ModulesValidator().validate(showHome.getModules().getEpisodes(), sa);

        new ModulesValidator().validate(showHome.getModules().getSeasons(), sa);

        new ModulesValidator().validate(showHome.getModules().getShowDetails(), sa);

        new ModulesValidator().validate(showHome.getModules().getShowStarring(), sa);
    }

}
