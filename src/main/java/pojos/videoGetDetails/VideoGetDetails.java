package pojos.videoGetDetails;

import com.fasterxml.jackson.annotation.JsonProperty;
import entities.Entity;

public class VideoGetDetails extends Entity {


        @JsonProperty("status")
        public String status;
        @JsonProperty("data")
        public Data data;

    }

