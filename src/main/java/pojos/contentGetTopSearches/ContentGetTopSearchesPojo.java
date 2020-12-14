package pojos.contentGetTopSearches;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class ContentGetTopSearchesPojo {
    @JsonProperty("entity_id")
    private String entity_id;
    @JsonProperty("image")
    private String image;
    @JsonProperty("entity_name")
    private String entity_name;
    @JsonProperty("entity_type")
    private String entity_type;
}
