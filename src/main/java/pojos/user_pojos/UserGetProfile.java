package pojos.user_pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class UserGetProfile {
    public UserGetProfile() {
    }

    @JsonProperty("playlist_count")
    private String playlist_count;
    @JsonProperty("firstname")
    private String firstname;
    @JsonProperty("lastname")
    private String lastname;
    @JsonProperty("uid")
    private String uid;
    @JsonProperty("pro")
    private String pro;
    @JsonProperty("username")
    private String username;
    @JsonProperty("fbid")
    private String fbid;
    @JsonProperty("image_url")
    private String image_url;
    @JsonProperty("phone_number")
    private String phone_number;
    @JsonProperty("email")
    private String email;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("dob")
    private String dob;
    @JsonProperty("following")
    private UserGetProfileFollowingData following;
    @JsonProperty("followed_by")
    private UserGetProfileFollowedByData followed_by;
    @JsonProperty("is_followed")
    private String is_followed;
    @JsonProperty("playlists")
    private List<PlaylistsData> playlists;
    @JsonProperty("recent_songs")
    private List<SongsData> recent_songs;
    @JsonProperty("status")
    private String status;
    @JsonProperty("music_identity")
    private String [] music_identity;
}
