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
public class ModuleViewMore {
    @JsonProperty("api")
    private String api;
    @JsonProperty("page_param")
    private String pageParam;
    @JsonProperty("size_param")
    private String sizeParam;
    @JsonProperty("default_size")
    private Integer defaultSize;
    @JsonProperty("scroll_type")
    private String scrollType;
    @JsonProperty("type")
    private String type;
    @JsonProperty("deeplink")
    private String deeplink;
}
