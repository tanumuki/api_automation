package pojos.JiotunepageCallerTune;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.Entity;
import entities.MultipleTunes;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter

public class NameCallerTuneContainer {
    @JsonProperty("last_page")
    public Boolean lastPageBool;
    @JsonProperty("modules")
    public JTModules modules;
    private Map<String, MultipleTunes[]> allNameTune = new HashMap<>();
    @JsonAnySetter
    public void setProviders1(String key, MultipleTunes[] val){
        allNameTune.put(key, val);
    }

}
