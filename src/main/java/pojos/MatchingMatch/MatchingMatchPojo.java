package pojos.MatchingMatch;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Data
@Getter
@Setter
public class MatchingMatchPojo {
    private Map<String, MatchingMatchData[]> entityType = new HashMap<>();
    @JsonAnySetter
    public void setProviders(String key, MatchingMatchData[] val){
        entityType.put(key, val);
    }
}
