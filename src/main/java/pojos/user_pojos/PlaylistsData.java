package pojos.user_pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.PlaylistMoreInfo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class PlaylistsData {
    public PlaylistsData() {
    }

    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("subtitle")
    private String subtitle;
    @JsonProperty("type")
    private String type;
    @JsonProperty ("perma_url")
    private String perma_url;
    @JsonProperty("image")
    private String image;
    @JsonProperty("language")
    private String language;
    @JsonProperty("year")
    private String year;
    @JsonProperty("play_count")
    private String play_count;
    @JsonProperty("explicit_content")
    private String explicit_content;
    @JsonProperty("list_count")
    private String list_count;
    @JsonProperty("list_type")
    private String list_type;
    @JsonProperty("list")
    private String list;
    @JsonProperty("more_info")
    private PlaylistMoreInfo more_info;

}
