package pojos.libraryOps;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.AlbumMoreInfo;
import entities.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class LibraryEntities extends Entity {

    public LibraryEntities(){}

    @JsonProperty("list")
    private Object list;
    @JsonProperty("more_info")
    private AlbumMoreInfo moreInfo;
    @JsonProperty("id")
    public String id;
    @JsonProperty("title")
    public String title;
    @JsonProperty("subtitle")
    public String subtitle;
    @JsonProperty("type")
    public String type;
    @JsonProperty("image")
    public String image;
    @JsonProperty("perma_url")
    public String permaUrl;
    @JsonProperty("explicit_content")
    public String explicitContent;
    @JsonProperty("mini_obj")
    public Boolean miniObj;







}
