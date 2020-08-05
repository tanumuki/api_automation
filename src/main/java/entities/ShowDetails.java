package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ShowDetails extends Entity{

    @JsonProperty("list")
    private String list;

    @JsonProperty("more_info")
    private ShowMoreInfo moreInfo;
}
