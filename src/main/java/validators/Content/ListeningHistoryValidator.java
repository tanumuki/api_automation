package validators.Content;

import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import pojos.content.ListeningHistory;
import pojos.content.ListeningHistoryMedia;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.EntityValidator;

import java.util.LinkedHashMap;

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
//          Validate history metadata "playcount" and "ts"
            sa.assertTrue(Validate.asNum(lhm.getPlayCount()),
                    AssertionMsg.print(className, methodName, "song playcount", Integer.toString(lhm.getPlayCount())));
            sa.assertTrue(Validate.asUnixEpochTime(String.valueOf(lhm.getTs())),
                    AssertionMsg.print(className, methodName, "last played ts", String.valueOf(lhm.getTs())));

//          Checking for both episode and song objects using AssortedEntity
            Validate.asAssortedEntity((LinkedHashMap)lhm.getMedia(), sa);
        }
    }

}