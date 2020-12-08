package validators.Content;

import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import pojos.content.ListeningHistory;
import pojos.content.ListeningHistoryMedia;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.EntityValidator;
import validators.genericValidators.SongValidator;

/**
 * @author ashwinsriv
 *
 */

@Slf4j

public class ListeningHistoryValidator extends EntityValidator {

    final String className = getClass().getName();

    public void validateListeningHistory(ListeningHistory lHistory, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        sa.assertTrue(Validate.asBoolean(lHistory.isEndReach()),
                AssertionMsg.print(className, methodName, "endReach", String.valueOf(lHistory.isEndReach()) ));

        for (ListeningHistoryMedia lhm : lHistory.getResults()) {
            //        Validate song objects
            sa.assertTrue(Validate.asNum(lhm.getPlayCount()),
                    AssertionMsg.print(className, methodName, "song playcount", Integer.toString(lhm.getPlayCount())));
            sa.assertTrue(Validate.asUnixEpochTime(String.valueOf(lhm.getTs())),
                    AssertionMsg.print(className, methodName, "last played ts", String.valueOf(lhm.getTs())));

            System.out.println("Checking listening history item: " + lhm.getMedia().getId() + "\t" + lhm.getMedia().getTitle());
            new SongValidator().validate(lhm.getMedia(), sa, lhm.getMedia().getId(),"listening history song object");
        }
    }

}