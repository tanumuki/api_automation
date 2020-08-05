/**
 * 
 */
package validators.genericValidators;

import org.testng.asserts.SoftAssert;

import entities.Artist;
import validators.AssertionMsg;
import validators.Validate;

/**
 * @author aswingokulachandran
 *
 */
public class ArtistMapValidator {
	final String className = SongValidator.class.getName();

	public void validate(Artist artist, SoftAssert sa, String artistType, String sourceType, String sourceEntity) {
		final String methodName = new Throwable().getStackTrace()[0].getMethodName();

		sa.assertTrue(Validate.asId(artist.getId()), AssertionMsg.print(className, methodName, sourceType,
				"more_info.artistMap." + artistType + ".artist.id", artist.getId(), sourceEntity));

		sa.assertTrue(Validate.asString(artist.getName()), AssertionMsg.print(className, methodName, sourceType,
				"more_info.artistMap." + artistType + ".artist.name", artist.getName(), sourceEntity));

		sa.assertTrue(Validate.asString(artist.getRole()), AssertionMsg.print(className, methodName, sourceType,
				"more_info.artistMap." + artistType + ".artist.role", artist.getRole(), sourceEntity));

		sa.assertTrue(Validate.asUrl(artist.getImage()), AssertionMsg.print(className, methodName, sourceType,
				"more_info.artistMap." + artistType + ".artist.image", artist.getImage(), sourceEntity));

		sa.assertTrue(Validate.asString(artist.getType()), AssertionMsg.print(className, methodName, sourceType,
				"more_info.artistMap." + artistType + ".artist.type", artist.getType(), sourceEntity));

		sa.assertTrue(Validate.asUrl(artist.getPermaUrl()), AssertionMsg.print(className, methodName, sourceType,
				"more_info.artistMap." + artistType + ".artist.perma_url", artist.getPermaUrl(), sourceEntity));
	}

}
