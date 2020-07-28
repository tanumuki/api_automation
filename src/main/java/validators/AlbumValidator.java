/**
 * 
 */
package validators;

import org.testng.asserts.SoftAssert;

import entities.Album;
import entities.Song;

/**
 * @author aswingokulachandran
 *
 */
public class AlbumValidator {
	
	public void validate(Album album, SoftAssert sa) {
		for(Song song : album.getList()) {
			
		}
	}

}
