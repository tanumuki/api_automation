package pojos.searchTabHomePage;

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
public class SearchTabData {
    @JsonProperty("type")
    private String type;
    @JsonProperty("data")
    private List<LinkedHashMap> data;
}
