package validators.genericValidators;

import entities.Episode;
import entities.EpisodeDetails;
import entities.EpisodeDetailsModules;
import org.testng.asserts.SoftAssert;

public class EpisodeDetailsValidator {
    final String className = getClass().getName();

    public void validate(EpisodeDetails ed, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        for(Episode episode : ed.getEpisodes()){
            new EpisodeValidator().validate(episode, sa);
        }

        //Validate modules
        EpisodeDetailsModules modules = ed.getModules();

        new ModulesDataValidator().validate(modules.getEpisode_details(), sa);
        new ModulesDataValidator().validate(modules.getEpisode_starring(), sa);
    }
}
