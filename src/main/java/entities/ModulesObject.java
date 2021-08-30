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
public class ModulesObject {
    @JsonProperty("data_0")
    private ModulesWithViewMoreObj data_0;
    @JsonProperty("data_1")
    private ModulesWithViewMoreObj data_1;
    @JsonProperty("data_2")
    private ModulesWithViewMoreObj data_2;
    @JsonProperty("data_3")
    private ModulesWithViewMoreObj data_3;
    @JsonProperty("data_4")
    private ModulesWithViewMoreObj data_4;
    @JsonProperty("data_5")
    private ModulesWithViewMoreObj data_5;
    @JsonProperty("data_6")
    private ModulesWithViewMoreObj data_6;
    @JsonProperty("trending_jiotunes")
    private ModulesWithViewMoreObj trending_jiotunes;
}
