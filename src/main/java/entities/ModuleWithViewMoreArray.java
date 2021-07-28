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
public class ModuleWithViewMoreArray extends ModulesData {
    @JsonProperty("view_more")
    private List<Object> viewMore;
    @JsonProperty("is_JT_module")
    private boolean isJTFlag;
}
