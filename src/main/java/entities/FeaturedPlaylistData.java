package entities;

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
public class FeaturedPlaylistData {

    @JsonProperty("data")
    private List<PlaylistMini> featuredPlayLists;
    @JsonProperty("count")
    private int count;
    @JsonProperty("last_page")
    private Boolean last_page;
}
