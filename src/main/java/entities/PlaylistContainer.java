package entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class PlaylistContainer extends Entity{
    @JsonProperty("status")
    private String status;
    @JsonProperty("data")
    private List<PlaylistMini> data;
}
