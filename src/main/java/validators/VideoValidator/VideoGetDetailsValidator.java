package validators.VideoValidator;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.ArtistMap;
import entities.Rights;
import entities.VideoMoreInfo;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import pojos.search.MoreInfo;
import pojos.videoGetDetails.VideoGetDetails;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.ArtistMapValidator;
import validators.genericValidators.EntityValidator;
import validators.genericValidators.RightsValidator;

import java.util.*;

@Slf4j
public class VideoGetDetailsValidator  extends EntityValidator {


    final String className = getClass().getName();

    public void validate(VideoGetDetails videoObj, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

        //Validating common entities
        super.validate(videoObj, sa);

        //Validating status
        if(Validate.isNonEmptyString(videoObj.status)){
            sa.assertTrue(Validate.API_STATUS_SUCCESS.matches(videoObj.status));
        }
        else{
            sa.fail("Response failed");
        }

        //Validating more info

        validateVideoMoreInfo(videoObj.data.getVideoMoreInfo(), sa,videoObj.getId());
    }



    public  void validateVideoMoreInfo(VideoMoreInfo mi, SoftAssert sa, String videoPid) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        //Validating artist Map
        ArtistMap artistMap = mi.getArtistMap();
        new ArtistMapValidator().validate(artistMap, sa, "video", videoPid);



        if(Validate.isNonEmptyString(mi.getLabel()))
            sa.assertTrue(Validate.asString(mi.getLabel()), AssertionMsg.print(className, methodName, "videoGetDetails.more_info.label", mi.getLabel()));
        else {
            log.info("Label is empty/Null");
        }


        if(Validate.isNonEmptyString(mi.getOrigin()))
            sa.assertTrue(Validate.asString(mi.getOrigin()), AssertionMsg.print(className, methodName, "videoGetDetails.more_info.origin", mi.getOrigin()));
        else {
            log.info("origin is empty/Null");
        }


        if(Validate.isNonEmptyString(mi.getMusic()))
            sa.assertTrue(Validate.asString(mi.getMusic()), AssertionMsg.print(className, methodName, "videoGetDetails.more_info.origin", mi.getMusic()));
        else {
            log.info("music is empty/Null");
        }


        if(Validate.isNonEmptyString(mi.getEncryptedMediaUrl()))
            sa.assertTrue(Validate.asExternalURL(mi.getEncryptedMediaUrl()), AssertionMsg.print(className, methodName, "album.more_info.EncryptedMediaUrl", mi.getEncryptedMediaUrl()));
        else {
            log.info("Encrypted Media URL is empty/Null");
        }


        if(Validate.isNonEmptyString(mi.getThumbnailUrl()))
            sa.assertTrue(Validate.asCDNURL(mi.getThumbnailUrl()), AssertionMsg.print(className, methodName, "album.more_info.ThumbnailUrl", mi.getThumbnailUrl()));
        else {
            log.info("ThumbnailUrl is empty/Null");
        }


        if(Validate.isNonEmptyString(mi.getDuration()))
            sa.assertTrue(Validate.asNum(mi.getDuration()), AssertionMsg.print(className, methodName, "album.more_info.Duration", mi.getDuration()));
        else {
            log.info("Duration is empty/Null");
        }


        if(Validate.isNonEmptyString(mi.getCacheState()))
            sa.assertTrue(Validate.asBoolean(mi.getCacheState()), AssertionMsg.print(className, methodName, "album.more_info.CacheState", mi.getCacheState()));
        else {
            log.info("Cache state is empty/Null");
        }


        if(Validate.isNonEmptyString(mi.getHasLyrics()))
            sa.assertTrue(Validate.asString(mi.getHasLyrics()), AssertionMsg.print(className, methodName, "album.more_info.HasLyrics", mi.getHasLyrics()));
        else {
            log.info("Has lyrics is empty/Null");
        }


        if(Validate.isNonEmptyString(mi.getLyricsSnippet()))
            sa.assertTrue(Validate.asString(mi.getLyricsSnippet()), AssertionMsg.print(className, methodName, "album.more_info.LyricsSnippet", mi.getLyricsSnippet()));
        else {
            log.info("Lyrics snippet is empty/Null");
        }


        if(Validate.isNonEmptyString(mi.getStarred()))
            sa.assertTrue(Validate.asBoolean(mi.getStarred()), AssertionMsg.print(className, methodName, "album.more_info.Starred", mi.getStarred()));
        else {
            log.info("Starred is empty/Null");
        }


        if(Validate.isNonEmptyString(mi.getCopyrightText()))
            sa.assertTrue(Validate.asString(mi.getCopyrightText()), AssertionMsg.print(className, methodName, "album.more_info.CopyrightText", mi.getCopyrightText()));
        else {
            log.info("Copyright text is empty/Null");
        }


        if(Validate.isNonEmptyString(mi.getPreviewUrl()))
            sa.assertTrue(Validate.asCDNURL(mi.getPreviewUrl()), AssertionMsg.print(className, methodName, "album.more_info.PreviewUrl", mi.getPreviewUrl()));
        else {
            log.info("Preview URL is empty/Null");
        }


        if(mi.getSongMappings()  instanceof List && mi.getSongMappings()!=null){

            Deque<String> songDeque = new ArrayDeque<String>();

            for(String song : mi.getSongMappings()){
                songDeque.add(song);

            }
            System.out.println("Song mapping List "+songDeque);
            //at this point we have added all the songs to the collection and we are validating the pids

            for( String song : songDeque){
                sa.assertTrue(Validate.asId(song), AssertionMsg.print(className, methodName, "album.more_info.song_mappings", song));
            }
            log.info("All the song mappings verified successfully!");
        }

            //Validating rights

            new RightsValidator().validate(mi.getRights(),sa, "video", videoPid );


    }
}
