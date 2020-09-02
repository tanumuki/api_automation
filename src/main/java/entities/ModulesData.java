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
public class ModulesData {
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
    @JsonProperty("hideMeta")
    private Boolean hideMeta;
    @JsonProperty("source_api")
    private Boolean sourceApi;
    @JsonProperty("source_params")
    private ModulesSourceParams sourceParams;
    @JsonProperty("featured")
    private Boolean featured;
    @JsonProperty("featured_text")
    private String featuredText;

}
