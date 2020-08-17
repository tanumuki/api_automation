/**
 * 
 */
package validators.genericValidators;

import entities.ArtistMap;
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

	public void validate(ArtistMap artistMap, SoftAssert sa, String sourceType, String sourceId) {
		for(Artist artist : artistMap.getPrimaryArtists()) {
			new ArtistMapValidator().validate(artist, sa, "primary_artists", sourceType, sourceId);
		}

		for(Artist artist : artistMap.getFeaturedArtists()) {
			new ArtistMapValidator().validate(artist, sa, "featured_artists", sourceType, sourceId);
		}

		for(Artist artist : artistMap.getArtists()) {
			new ArtistMapValidator().validate(artist, sa, "artists", sourceType, sourceId);
		}
	}

	public void validate(Artist artist, SoftAssert sa, String artistType, String sourceType, String sourceEntity) {
		final String methodName = new Throwable().getStackTrace()[0].getMethodName();

		sa.assertTrue(Validate.asId(artist.getId()), AssertionMsg.print(className, methodName, sourceType,
				"more_info.artistMap." + artistType + ".artist.id", artist.getId(), sourceEntity));

		sa.assertTrue(Validate.asString(artist.getName()), AssertionMsg.print(className, methodName, sourceType,
				"more_info.artistMap." + artistType + ".artist.name", artist.getName(), sourceEntity));

		sa.assertTrue(Validate.asString(artist.getRole()), AssertionMsg.print(className, methodName, sourceType,
				"more_info.artistMap." + artistType + ".artist.role", artist.getRole(), sourceEntity));

		sa.assertTrue(Validate.asCDNURL(artist.getImage()), AssertionMsg.print(className, methodName, sourceType,
				"more_info.artistMap." + artistType + ".artist.image", artist.getImage(), sourceEntity));

		sa.assertTrue(Validate.asArtistType(artist.getType()), AssertionMsg.print(className, methodName, sourceType,
				"more_info.artistMap." + artistType + ".artist.type", artist.getType(), sourceEntity));

		sa.assertTrue(Validate.asPermaURL(artist.getPermaUrl()), AssertionMsg.print(className, methodName, sourceType,
				"more_info.artistMap." + artistType + ".artist.perma_url", artist.getPermaUrl(), sourceEntity));
	}

}
