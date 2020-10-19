package pojos.podcastsGetAll;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class PodcastCategoryMoreInfo {
    @JsonProperty("bg_color")
    private String bgColor;
    @JsonProperty("square_image")
    private String squareImage;
    @JsonProperty("description")
    private String description;
}
