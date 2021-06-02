package validators;

import entities.FeaturedPlaylistData;
import entities.PlaylistMini;
import org.testng.asserts.SoftAssert;

@SuppressWarnings("ALL")
public class GetFeaturedPlayListValidator {
    final String className = getClass().getName();
    public void validate(FeaturedPlaylistData featuredPlaylistData, SoftAssert sa)
    {
        for (PlaylistMini playlistMini: featuredPlaylistData.getFeaturedPlayLists())
        {
            new PlaylistMiniValidator().validate(playlistMini, sa);
        }
        sa.assertTrue(Validate.asNum(featuredPlaylistData.getCount()),className + "." + "validate count failed");
        sa.assertTrue(Validate.asBoolean(featuredPlaylistData.getLast_page()),className + "." + "validate last_page failed");

    }
}
