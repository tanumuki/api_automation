package validators.genericValidators;

import entities.EditorsNote;
import org.testng.asserts.SoftAssert;
import validators.AssertionMsg;
import validators.Validate;

public class EditorsNoteValidator {
    final String className = getClass().getName();
    public void validate(EditorsNote en, SoftAssert sa, String entityType, String entityId) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        if(en != null) {
            if(en.getTitle() != null)
                sa.assertTrue(Validate.asString(en.getTitle()), AssertionMsg.print(className, methodName, entityType, "more_info.editors_note.title", en.getTitle(), entityId));

            if(en.getMessage() != null)
                sa.assertTrue(Validate.asString(en.getMessage()), AssertionMsg.print(className, methodName, entityType, "more_info.editors_note.message", en.getMessage(), entityId));

            if(en.getImage() != null)
                sa.assertTrue(Validate.asCDNURL(en.getImage()), AssertionMsg.print(className, methodName, entityType, "more_info.editors_note.image", en.getImage(), entityId));
        }

    }
}
