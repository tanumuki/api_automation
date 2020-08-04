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
    private List<Object> seasonality;
    @JsonProperty("situation")
    private List<Object> situation;
    @JsonProperty("mood")
    private List<Object> mood;
    @JsonProperty("genre")
    private List<Object> genre;
}
