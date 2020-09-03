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
public class MixMoreInfo {
    @JsonProperty("contents")
    private String contents;
    @JsonProperty("color_code")
    private String colorCode;
    @JsonProperty("uid")
    private String uid;
    @JsonProperty("firstname")
    private String firstname;
    @JsonProperty("lastname")
    private String lastname;
    @JsonProperty("last_updated")
    private String lastUpdated;
    @JsonProperty("reward")
    private String reward;
    @JsonProperty("position")
    private String position;
    @JsonProperty("list")
    private String list;
    @JsonProperty("type")
    private String type;



}
