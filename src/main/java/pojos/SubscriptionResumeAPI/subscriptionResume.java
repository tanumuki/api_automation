package pojos.SubscriptionResumeAPI;

import com.fasterxml.jackson.annotation.JsonProperty;
import entities.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter

public class subscriptionResume extends Entity {

    @JsonProperty("status")
    private String status;

}
