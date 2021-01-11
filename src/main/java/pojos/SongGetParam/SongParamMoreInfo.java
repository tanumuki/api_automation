package pojos.SongGetParam;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class SongParamMoreInfo {
    private Map<String, Object> moreInfo = new HashMap<>();

    @JsonAnySetter
    public void setProviders(String key, Object val) {
        moreInfo.put(key, val);
    }

}
