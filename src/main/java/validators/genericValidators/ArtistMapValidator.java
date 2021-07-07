/**
 * 
 */
package validators.genericValidators;

import entities.ArtistMap;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;

import entities.Artist;
import validators.AssertionMsg;
import validators.Validate;

/**
 * @author aswingokulachandran
 *
 */

@Slf4j
public class ArtistMapValidator {
	final String className = SongValidator.class.getName();

	public void validate(ArtistMap artistMap, SoftAssert sa, String sourceType, String sourceId) {
		if(artistMap != null){
			for(Artist artist : artistMap.getPrimaryArtists()) {
				new ArtistMapValidator().validate(artist, sa, "primary_artists", sourceType, sourceId);
			}
			if( artistMap.getFeaturedArtists() != null) {
				for (Artist artist : artistMap.getFeaturedArtists()) {
					new ArtistMapValidator().validate(artist, sa, "featured_artists", sourceType, sourceId);
				}
			}
			else {
				log.info("Albums doesn't have the featured artists");
			}

			if( artistMap.getFeaturedArtists() != null) {
				for(Artist artist : artistMap.getArtists()) {
					new ArtistMapValidator().validate(artist, sa, "artists", sourceType, sourceId);
				}
			}
			else {
				log.info("Albums doesn't have the artists");
			}
		}



	}

	public void validate(Artist artist, SoftAssert sa, String artistType, String sourceType, String sourceEntity) {
		final String methodName = new Throwable().getStackTrace()[0].getMethodName();

		sa.assertTrue(Validate.asId(artist.getId().trim()), AssertionMsg.print(className, methodName, sourceType,
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

		log.info("Validation done for "+artistType);
	}

}
