package validators;

import entities.Entity;
import entities.Playlist;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class PlaylistValidator extends EntityValidator {

    final String className = PlaylistValidator.class.getName();

    public void validate(Playlist playlistObj, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        super.validate(playlistObj,sa);

        sa.assertTrue(Validate.asString(playlistObj.getList()), AssertionMsg.print(className, methodName, "List", playlistObj.getList()));
        sa.assertTrue(Validate.asBoolean(playlistObj.getMore_info().getUid()), AssertionMsg.print(className, methodName, "Uid", playlistObj.getMore_info().getUid()));


    }

}
