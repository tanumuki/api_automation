package pojos.appGetLaunchData;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter

public class TopSearch {
//    fields below are pre-7.x
    @JsonProperty("entity_id")
    private String entityId;
    @JsonProperty("entity_name")
    private String entityName;
    @JsonProperty("entity_type")
    private String entityType;

//    fields below are post 7.x
    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("subtitle")
    private String subtitle;
    @JsonProperty("type")
    private String type;
    @JsonProperty("image")
    private String image;
    @JsonProperty("perma_url")
    private String perma_url;
    @JsonProperty("more_info")
    private Object moreInfo;
    @JsonProperty("explicit_content")
    private String explicit_content;
    @JsonProperty("mini_obj")
    private String mini_obj;
}
