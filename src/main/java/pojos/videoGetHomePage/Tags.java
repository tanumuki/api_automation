package pojos.videoGetHomePage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class Tags {
    @JsonProperty("genre")
    private List<String> genre = null;
    @JsonProperty("seasonality")
    private List<String> seasonality = null;
    @JsonProperty("situation")
    private List<String> situation = null;
    @JsonProperty("mood")
    private List<String> mood = null;
}
