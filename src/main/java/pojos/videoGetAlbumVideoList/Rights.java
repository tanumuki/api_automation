package pojos.videoGetAlbumVideoList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rights {

    @JsonProperty("code")
    public String code;
    @JsonProperty("cacheable")
    public String cacheable;
    @JsonProperty("delete_cached_object")
    public String deleteCachedObject;
    @JsonProperty("reason")
    public String reason;

}
