package pojos.MatchingMatch;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MatchingMatchData {

    @JsonProperty("id")
    private String id;
    @JsonProperty("language")
    private String language;
    @JsonProperty("url")
    private String url;
    @JsonProperty("deeplink")
    private String deeplink;
    @JsonProperty("season_number")
    private String season_number;
}
