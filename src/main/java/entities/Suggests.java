package entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class Suggests {
    @JsonProperty("headline")
    private String headline;
    @JsonProperty("badge")
    private String badge;
    @JsonProperty("items")
    private List<LinkedHashMap> items = null;
}
