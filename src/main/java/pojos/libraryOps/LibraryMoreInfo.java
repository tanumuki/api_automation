package pojos.libraryOps;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.AlbumMoreInfo;
import entities.ArtistMap;
import entities.Entity;
import entities.PlaylistMoreInfo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class LibraryMoreInfo extends Entity {

    public LibraryMoreInfo(){}

    @JsonProperty("artistMap")
    private ArtistMap artistMap;
    @JsonProperty("year")
    private String year;
    @JsonProperty("contents")
    private String contents;
    @JsonProperty("label")
    private String label;
    @JsonProperty("square_image")
    private String squareImage;

//    POJOs for Playlist
    @JsonProperty("username")
    public String username;
    @JsonProperty("uid")
    public String uid;
    @JsonProperty("creation_date")
    public String creationDate;
    @JsonProperty("share")
    public String share;
    @JsonProperty("last_updated")
    public String lastUpdated;
    @JsonProperty("favourite")
    public String favourite;
    @JsonProperty("owner")
    public String owner;
    @JsonProperty("owner_listid")
    public String ownerListid;
    @JsonProperty("normalized_listname")
    public String normalizedListname;
    @JsonProperty("follower_count")
    public String followerCount;
    @JsonProperty("song_count")
    public String songCount;
    @JsonProperty("firstname")
    public String firstname;
    @JsonProperty("lastname")
    public String lastname;
    @JsonProperty("is_followed")
    public String isFollowed;
    @JsonProperty("sub_types")
    public List<Object> subTypes = null;
    @JsonProperty("images")
    public List<Object> images = null;
    @JsonProperty("isFY")
    public Boolean isFY;
    @JsonProperty("video_count")
    public String videoCount;









}
