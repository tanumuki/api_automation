package pojos.JiotunepageCallerTune;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter

public class PopularArtistTune extends Entity {

//    @JsonProperty("type")
//    public String type;
//    @JsonProperty("subtype")
//    private String subtype;
    @JsonProperty("position")
    public Integer position;
    @JsonProperty("source")
    public String source;
    @JsonProperty("scroll_type")
    public String scrollType;
    @JsonProperty("noheader")
    public Boolean noheader;

}
