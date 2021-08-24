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
    @JsonProperty("contents")
    private String contents;
    @JsonProperty("label")
    private String label;
    @JsonProperty("square_image")
    private String squareImage;

}
