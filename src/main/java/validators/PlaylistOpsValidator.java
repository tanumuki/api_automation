package validators;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Playlist;
import entities.PlaylistContainer;
import entities.PlaylistMoreInfo;
import entities.UserProfilePlaylists;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import pojos.playlistOps.PlaylistMakePrivatePublic;
import validators.genericValidators.PlaylistValidator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Slf4j
public class PlaylistOpsValidator {

    final String className = getClass().getName();

    public void validate(PlaylistContainer playlistContainer, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        if(Validate.isNonEmptyString(playlistContainer.getStatus()))
            sa.assertTrue(Validate.asString(playlistContainer.getStatus()), AssertionMsg.print(className, methodName, "status", playlistContainer.getStatus()));
            log.info("Validation done for status "+playlistContainer.getStatus());

        if(playlistContainer.getDetails() != null){
            Playlist playlist = playlistContainer.getDetails();
            new PlaylistValidator().validate(playlist, sa);
        }else {
            sa.fail("Details object is empty, validation failed.");
        }
    }

    public void validatePlaylistDeletion(Playlist playlist, SoftAssert sa){
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        if(Validate.isNonEmptyString(playlist.getTitle())){
            sa.assertEquals(playlist.getTitle(), "", AssertionMsg.print(className, methodName, "title", playlist.getTitle()));
        }
        if(Validate.isNonEmptyString(playlist.getPermaUrl())){
            sa.assertEquals(playlist.getPermaUrl(), "", AssertionMsg.print(className, methodName, "perma_url", playlist.getPermaUrl()));
        }
        log.info("Validation done for title and perma_url to be null after deletion of the playlist with id: "+playlist.getId());

    }

    public void validatePrivatePlaylist(PlaylistMakePrivatePublic plObj, SoftAssert sa){
        PlaylistMoreInfo moreInfo = null;
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        Object temp = null;

        temp = plObj.getDetails().getMore_info();
        log.info("temp is: "+temp);

        if(temp instanceof LinkedHashMap) {
            moreInfo = mapper.convertValue(temp, PlaylistMoreInfo.class);
        }

        assert moreInfo != null;
        sa.assertTrue(moreInfo.getShare().equalsIgnoreCase("0"));


    }
}
