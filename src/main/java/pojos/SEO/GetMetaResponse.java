package pojos.SEO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class GetMetaResponse {
    @JsonProperty("_id")
    private String _id;
    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("title")
    private String title;
    @JsonProperty("keywords")
    private String keywords;
    @JsonProperty("description")
    private String description;
    @JsonProperty("h1")
    private String h1;
    @JsonProperty("alt")
    private String alt;


}
