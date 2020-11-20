package validators.JTGetMoreSongs;

import entities.Song;
import org.testng.asserts.SoftAssert;
import pojos.JTGetMoreSongs.JTGetMoreSongs;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.SongValidator;

public class JTGetMoreSongsValidator {
    final String className = getClass().getName();

    public void validate(JTGetMoreSongs ms, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        if(ms.getTotal() != null){
            sa.assertTrue(Validate.asNum(ms.getTotal()), AssertionMsg.print(className, methodName, "total", ms.getTotal().toString()));
        }else{
            sa.fail("Jiotunes Get More songs total count is null");
        }

        if(ms.getStart() != null){
            sa.assertTrue(Validate.asNum(ms.getStart()), AssertionMsg.print(className, methodName, "start", ms.getStart().toString()));
        }else{
            sa.fail("Jiotunes Get More songs start count is null");
        }

        sa.assertTrue(ms.getStart() <= ms.getTotal(), "Start > Total for Jiotunes get more songs");

        for(Song song : ms.getResults()){
            new SongValidator().validate(song, sa, "jiotune get more songs", song.getId());
        }
    }
}
