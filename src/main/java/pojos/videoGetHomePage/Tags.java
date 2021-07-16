package pojos.videoGetHomePage;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Tags {
    @JsonProperty("genre")
    public List<String> genre = null;
    @JsonProperty("seasonality")
    public List<String> seasonality = null;
    @JsonProperty("situation")
    public List<String> situation = null;
    @JsonProperty("mood")
    public List<String> mood = null;
}
