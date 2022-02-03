package pojos.content;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter

public class HandleUnsupportedDeeplinkData {
    @JsonProperty("update_app")
    private String update_app;
    @JsonProperty("msg")
    private String msg;
}
