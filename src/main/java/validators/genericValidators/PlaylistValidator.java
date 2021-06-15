package validators.genericValidators;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Entity;
import entities.Playlist;
import entities.PlaylistMoreInfo;
import entities.UserProfilePlaylists;
import org.testng.asserts.SoftAssert;
import validators.AssertionMsg;
import validators.Validate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
public class PlaylistValidator extends EntityValidator {

    final String className = PlaylistValidator.class.getName();
    ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
    public void validate(Playlist playlistObj, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        super.validate(playlistObj, sa);

        if(playlistObj != null) {
            if(playlistObj.getList() instanceof String){
                String listVal = mapper.convertValue(playlistObj.getList(), String.class);
                sa.assertTrue(listVal.equals(""), AssertionMsg.print(className, methodName, "playlist.list", listVal));
            }else if(playlistObj.getList() instanceof ArrayList<?>) {
                List<LinkedHashMap> songlist = mapper.convertValue(playlistObj.getList(), ArrayList.class);
                Validate.asAssortedEntity(songlist, sa);
            }else{
                sa.fail("Unsupported type for playlist.list field");
            }

            validateMoreInfo(playlistObj, sa);
            //TODO: Modules validation
        }


    }

    public void validate(UserProfilePlaylists playlistObj, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        super.validate(playlistObj, sa);
        validateMoreInfo(playlistObj, sa);
    }

    public void validateMoreInfo(Entity plObj, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        PlaylistMoreInfo moreInfo;

        try {
            moreInfo = ((Playlist) plObj).getMore_info();

        } catch (ClassCastException e) {
            moreInfo = ((UserProfilePlaylists) plObj).getMore_info();
        }
        if(Validate.isNonEmptyString(moreInfo.getUid()))
            sa.assertTrue(Validate.asString(moreInfo.getUid()), AssertionMsg.print(className, methodName, "playlist.more_info.uid", moreInfo.getUid()));

        if(Validate.isNonEmptyString(moreInfo.getLast_updated()))
            sa.assertTrue(Validate.asString(moreInfo.getLast_updated()), AssertionMsg.print(className, methodName, "playlist.more_info.last_updated", moreInfo.getLast_updated()));

        if(Validate.isNonEmptyString(moreInfo.getUsername()))
            sa.assertTrue(Validate.asString(moreInfo.getUsername()), AssertionMsg.print(className, methodName, "playlist.more_info.username", moreInfo.getUsername()));

        if(Validate.isNonEmptyString(moreInfo.getFirstname()))
            sa.assertTrue(Validate.asString(moreInfo.getFirstname()), AssertionMsg.print(className, methodName, "playlist.more_info.firstname", moreInfo.getFirstname()));

        if(Validate.isNonEmptyString(moreInfo.getLastname()))
            sa.assertTrue(Validate.asString(moreInfo.getLastname()), AssertionMsg.print(className, methodName, "playlist.more_info.lastname", moreInfo.getLastname()));

        if(Validate.isNonEmptyString(moreInfo.getIs_followed()))
            sa.assertTrue(Validate.asString(moreInfo.getIs_followed()), AssertionMsg.print(className, methodName, "playlist.more_info.is_followed", moreInfo.getIs_followed()));

        if(Validate.isNonEmptyString(moreInfo.getFollower_count()))
            sa.assertTrue(Validate.asNum(moreInfo.getFollower_count()), AssertionMsg.print(className, methodName, "playlist.more_info.follower_count", moreInfo.getFollower_count()));

//        sa.assertTrue(Validate.asNum(moreInfo.getFan_count()), AssertionMsg.print(className, methodName, "playlist.more_info.fan_count", moreInfo.getFan_count()));

//        sa.assertTrue(Validate.asString(moreInfo.getPlaylist_type()), AssertionMsg.print(className, methodName, "playlist.more_info.playlist_type", moreInfo.getPlaylist_type()));

        if(Validate.isNonEmptyString(moreInfo.getShare()))
            sa.assertTrue(Validate.asString(moreInfo.getShare()), AssertionMsg.print(className, methodName, "playlist.more_info.share", moreInfo.getShare()));

        //Validate is_dolby_content
        if(moreInfo.getIs_dolby_content() != null){
            sa.assertTrue(Validate.asBoolean(moreInfo.getIs_dolby_content()), AssertionMsg.print(className, methodName, "playlist.more_info.is_dolby_content", String.valueOf(moreInfo.getIs_dolby_content())));
        }

        //Validate subtype

        if(moreInfo.getSub_types() != null && moreInfo.getSub_types().size() > 0){
            for(String subtype : moreInfo.getSub_types()){
                sa.assertTrue(Validate.asPlaylistSubtype(subtype), AssertionMsg.print(className, methodName, "playlist.more_info.subtype", subtype));
            }
        }

//        Adding an empty assertion for now as this field is empty for all playlist API calls.
//        If this assert fails, please check the JSON response and add the necessary validations - Ashwin
        if(moreInfo.getImages()!=null) {
            sa.assertTrue(moreInfo.getImages().isEmpty(), AssertionMsg.print(className, methodName, "playlist.more_info.images", moreInfo.getImages().toString()));
        }

        if(moreInfo.getSubtype() instanceof List){
            sa.assertTrue(((List<?>)moreInfo.getSubtype()).size() == 0, "Playlist more_info.subtype of type list has contents. Test validations need to be added.");
        } else if(moreInfo.getSubtype() != null){
            sa.fail("Unsupported subtype for playlist with id - " + plObj.getId());
        }

        if(Validate.isNonEmptyString(moreInfo.getVideo_count())) {
            sa.assertTrue(Validate.asNum(moreInfo.getVideo_count()),
                    AssertionMsg.print(className, methodName, "playlist.more_info.video_count",moreInfo.getVideo_count()));
        }
    }

}
