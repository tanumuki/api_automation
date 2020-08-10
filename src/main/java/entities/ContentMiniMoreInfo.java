package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ContentMiniMoreInfo {
    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("song_count")
    private String song_count;
}
