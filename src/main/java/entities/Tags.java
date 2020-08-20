package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
/*
    Channel Tags
 */
@Data
@Getter
@Setter
public class Tags {

    @JsonProperty("seasonality")
    private List<String> seasonality;
    @JsonProperty("situation")
    private List<String> situation;
    @JsonProperty("mood")
    private List<String> mood;
    @JsonProperty("genre")
    private List<String> genre;
}
