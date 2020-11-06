package pojos.benefits;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Data
public class BenefitsListData {

    @JsonProperty("id")
    private String id;
    @JsonProperty("show_raw_code")
    private boolean show_raw_code;
    @JsonProperty("title")
    private String title;
    @JsonProperty("subtitle")
    private String subtitle;
    @JsonProperty("event_date")
    private String event_date;
    @JsonProperty("desc")
    private String desc;
    @JsonProperty("cover_art")
    private String cover_art;
    @JsonProperty("terms")
    private String [] terms;
    @JsonProperty("codes_info")
    private String codes_info;
    @JsonProperty("ticket_info")
    private String ticket_info;
    @JsonProperty("expiry")
    private String expiry;
    @JsonProperty("used_count")
    private String used_count;
    @JsonProperty("access")
    private String[] access;
    @JsonProperty("priority")
    private String priority;
    @JsonProperty("created_at")
    private String created_at;
    @JsonProperty("status")
    private String status;
    @JsonProperty("section")
    private String section;
    @JsonProperty("code")
    private String code;
}
