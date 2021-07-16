package pojos.videoGetHomePage;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ModulesVideoStations {

    @JsonProperty("source")
    public String source;
    @JsonProperty("position")
    public Integer position;
    @JsonProperty("scroll_type")
    public String scrollType;
    @JsonProperty("title")
    public String title;
    @JsonProperty("subtitle")
    public String subtitle;
    @JsonProperty("highlight")
    public String highlight;
    @JsonProperty("simpleHeader")
    public Boolean simpleHeader;
    @JsonProperty("noHeader")
    public Boolean noHeader;
    @JsonProperty("view_more")
    public List<Object> viewMore = null;
}
