package pojos.videoGetHomePage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class ModulesVideoStations {

    @JsonProperty("source")
    private String source;
    @JsonProperty("position")
    private Integer position;
    @JsonProperty("scroll_type")
    private String scrollType;
    @JsonProperty("title")
    private String title;
    @JsonProperty("subtitle")
    private String subtitle;
    @JsonProperty("highlight")
    private String highlight;
    @JsonProperty("simpleHeader")
    private Boolean simpleHeader;
    @JsonProperty("noHeader")
    private Boolean noHeader;
    @JsonProperty("view_more")
    private List<Object> viewMore = null;
}
