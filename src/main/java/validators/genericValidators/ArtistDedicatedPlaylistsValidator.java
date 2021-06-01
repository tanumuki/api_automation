package validators.genericValidators;

import entities.*;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import validators.PlaylistMiniValidator;
import java.util.Map;

/**
 * @author snigdhamajee
 *
 */

@Slf4j
public class ArtistDedicatedPlaylistsValidator {
    final String className = getClass().getName();

    public void validate(DedicatedArtistPlaylist dedicatedArtistPlaylistPojo, SoftAssert sa, String artistID) {
        for (Map.Entry<String, PlaylistMini[]> data : dedicatedArtistPlaylistPojo.getArtistID().entrySet()) {
            System.out.println(dedicatedArtistPlaylistPojo.getArtistID().entrySet());
            String key_artistid = data.getKey();
            sa.assertEquals(key_artistid, artistID, className + ": artistid's don't match");

            for (PlaylistMini playlistMiniPojo : data.getValue()) {
                new PlaylistMiniValidator().validate(playlistMiniPojo, sa);
            }
            }
        }
}

