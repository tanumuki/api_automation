package pojos.JiotuneHomePageData;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class JiotuneHomePageData {
    @JsonProperty("data_0")
    private List<JTMenu> data_0;
    @JsonProperty("data_1")
    private List<Song> data_1;
    @JsonProperty("data_2")
    private List<LinkedHashMap> data_2;
    @JsonProperty("data_3")
    private List<LinkedHashMap> data_3;
    @JsonProperty("data_4")
    private List<LinkedHashMap> data_4;
    @JsonProperty("data_5")
    private List<LinkedHashMap> data_5;
    @JsonProperty("data_6")
    private List<LinkedHashMap> data_6;
    @JsonProperty("data_7")
    private List<LinkedHashMap> data_7;
    @JsonProperty("trending_jiotunes")
    private List<Song> trending_jiotunes;
    @JsonProperty("modules") // The JSONArray has been changed to a JSONObject as of 7th July, 2021 - Ashwin
    private ModulesObject modules;
    @JsonProperty("jiotune_reco")
    private List<Song> jiotune_reco;
    @JsonProperty("cta_text")
    private String cta_text;
    @JsonProperty("show_delete")
    private String show_delete;
    @JsonProperty("cta_action")
    private String cta_action;
//    TODO: Use JSONAnySetter for handling dynamic fields
}
