package validators;

import entities.Playlist;
import entities.PlaylistContainer;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import validators.genericValidators.PlaylistValidator;

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
}
