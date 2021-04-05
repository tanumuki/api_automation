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
public class ModulesWithViewMoreObj extends ModulesData {
    @JsonProperty("view_more")
    private ModuleViewMore viewMore;
    @JsonProperty("total_count")
    private int total_count;
    @JsonProperty("scroll_limit")
    private int scroll_limit;
    @JsonProperty("type")
    private String type;

}
