package validators.CheckSongsRights;

import entities.Rights;
import org.testng.asserts.SoftAssert;
import pojos.SubsCheckSongRights.CheckSongsRights;
import validators.genericValidators.RightsValidator;

public class CheckSongsRightsValidator {
    final String className = getClass().getName();

    public void validate(CheckSongsRights rights, SoftAssert sa, String pids) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        if(pids.indexOf(",") < 0){
            Rights songRights = rights.getSongRights().get(pids);
            new RightsValidator().validate(songRights, sa, "song", pids);
        }else {
            String[] songs = pids.split(",");
            for(String pid : songs) {
                Rights songRights = rights.getSongRights().get(pid);
                if(songRights != null)
                    new RightsValidator().validate(songRights, sa, "song", pids);
                else
                    sa.fail(className + " - " + methodName + " - missing rights for pid - " + pid );
            }
        }

    }
}
