package entities;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
@Getter
@Setter
public class EditorsNote {

    @JsonProperty("title")
    private String title;
    @JsonProperty("message")
    private String message;
    @JsonProperty("image")
    private String image;

    @JsonAnySetter
    Map<String, Object> asObjs = new LinkedHashMap<>();

//    @JsonAnySetter
//    Map<String, List<Object>> asLists = new LinkedHashMap<>();

}
