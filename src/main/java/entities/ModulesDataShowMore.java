package entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter

public class ModulesDataShowMore {
    @JsonProperty("type")
    private String type;
    @JsonProperty("source")
    private String source;
    @JsonProperty("params")
    private Params params;
    @JsonProperty("title")
    private String title;
    @JsonProperty("page_param")
    private String page_param;
    @JsonProperty("size_param")
    private String size_param;
    @JsonProperty("default_size")
    private Integer default_size;
    @JsonProperty("scroll_type")
    private String scroll_type;


}
