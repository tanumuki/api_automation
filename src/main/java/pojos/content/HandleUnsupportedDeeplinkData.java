package pojos.content;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HandleUnsupportedDeeplinkData {
    @JsonProperty("update_app")
    private String update_app;
    @JsonProperty("msg")
    private String msg;
}
