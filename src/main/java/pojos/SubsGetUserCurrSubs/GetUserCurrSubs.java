package pojos.SubsGetUserCurrSubs;

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
public class GetUserCurrSubs {
    @JsonProperty("status")
    private String status;
    @JsonProperty("data")
    private Object data; //TODO: create a subscription object and assign it as the data type of "data"
}
