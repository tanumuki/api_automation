package validators.genericValidators;

import entities.Genre;
import org.testng.asserts.SoftAssert;
import validators.AssertionMsg;
import validators.Validate;

public class GenreValidator {
    final String className = getClass().getName();
    public void validate(Genre g, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        if(g.getAbout() != null){
            sa.assertTrue(Validate.asString(g.getAbout()), AssertionMsg.print(className, methodName, "genre.about", g.getAbout()));
        }

        if(g.getImage() != null){
            sa.assertTrue(Validate.asUrl(g.getImage()), AssertionMsg.print(className, methodName, "genre.image", g.getImage()));
        }

        if(g.getTitle() != null){
            sa.assertTrue(Validate.asString(g.getTitle()), AssertionMsg.print(className, methodName, "genre.title", g.getTitle()));
        }

        if(g.getTags() != null){
            sa.assertTrue(Validate.asString(g.getTags()), AssertionMsg.print(className, methodName, "genre.tags", g.getTags()));
        }
    }
}
