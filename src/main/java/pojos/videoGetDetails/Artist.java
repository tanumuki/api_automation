package pojos.videoGetDetails;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Artist {

    @JsonProperty("id")
    public String id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("role")
    public String role;
    @JsonProperty("image")
    public String image;
    @JsonProperty("type")
    public String type;
    @JsonProperty("perma_url")
    public String permaUrl;

}
