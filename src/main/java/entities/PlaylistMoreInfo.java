package entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class PlaylistMoreInfo {
    public PlaylistMoreInfo() {
    }

    @JsonProperty("username")
    private String username;
    @JsonProperty("uid")
    private String uid;
    @JsonProperty("contents")
    private String contents;
    @JsonProperty("creation_date")
    private String creation_date;
    @JsonProperty("share")
    private String share;
    @JsonProperty("last_updated")
    private String last_updated;
    @JsonProperty("favourite")
    private String favourite;
    @JsonProperty("owner")
    private String owner;
    @JsonProperty("owner_listid")
    private String owner_listid;
    @JsonProperty("normalized_listname")
    private String normalized_listname;
    @JsonProperty("follower_count")
    private String follower_count;
    @JsonProperty("song_count")
    private String song_count;
    @JsonProperty("firstname")
    private String firstname;
    @JsonProperty("lastname")
    private String lastname;
    @JsonProperty("is_followed")
    private String  is_followed;
    @JsonProperty("meta")
    private String[] meta;
    @JsonProperty("isFY")
    private String isFY;
    @JsonProperty("description")
    private String description;
    @JsonProperty("fan_count")
    private String fan_count;
    @JsonProperty("playlist_type")
    private String playlist_type;

//    values of H2 and subheading are null at this time (Jan 2021), so not creating any validators
    @JsonProperty("H2")
    private String H2;
    @JsonProperty("subheading")
    private String subheading;

    @JsonProperty("is_dolby_content")
    private Boolean is_dolby_content;

    @JsonProperty("subtype")
    private Object subtype;
}
