package validators;

import entities.ChartsData;
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
        sa.assertTrue(Validate.asNum(featuredPlaylistData.getCount()),className + "." + "validate count failed for entity type playlist");
        sa.assertTrue(Validate.asBoolean(featuredPlaylistData.getLast_page()),className + "." + "validate last_page failed or entity type playlist");

    }

    public void validate(ChartsData chartsData, SoftAssert sa)
    {
        sa.assertEquals(Validate.API_STATUS_SUCCESS,chartsData.getStatus(),className + "." + "validate status failed for entity type charts");

        for (PlaylistMini playlistMini: chartsData.getChatsList())
        {
            new PlaylistMiniValidator().validate(playlistMini, sa);
        }

    }
}
