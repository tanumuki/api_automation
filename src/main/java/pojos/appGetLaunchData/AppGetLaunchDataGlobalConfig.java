package pojos.appGetLaunchData;

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

public class AppGetLaunchDataGlobalConfig {
    @JsonProperty("stream_config")
    private StreamConfig streamConfig;

    @JsonProperty("ad_config")
    private AdConfig adConfig;
    @JsonProperty("supported_languages")
    private List<String> supportedLanguages;
    @JsonProperty("radio_supported_languages")
    private List<String> radioSupportedLanguages;
    @JsonProperty("label_info")
    private LabelInfo labelInfo;

    //TODO: Weekly_top_songs_listid

    @JsonProperty("weekly_top_songs_listid")
    private WT15Lists weekly_top_songs_listid;



    //TODO: random_songs_listid

    @JsonProperty("random_songs_listid")
    private RandomSongsLists random_songs_listid;

    @JsonProperty("product_details")
    private ProductDetails product_details;
    @JsonProperty("cache_config")
    private CacheConfig cacheConfig;
    @JsonProperty("phn_otp_providers")
    private OTPProviders phn_otp_providers;
    @JsonProperty("trial")
    private Trial trial;
    @JsonProperty("upi_providers")
    private List<String> upiProviders = null;

    @JsonProperty("spotlight_image_width")
    private String spotlight_image_width;
    @JsonProperty("spotlight_image_height")
    private String spotlight_image_height;
    @JsonProperty("spotlight_image_expiry")
    private String spotlight_image_expiry;
    @JsonProperty("spotlight_view_image_width")
    private String spotlight_view_image_width;
    @JsonProperty("spotlight_view_image_height")
    private String spotlight_view_image_height;
    @JsonProperty("spotlight_view_image_expiry")
    private String spotlight_view_image_expiry;
    @JsonProperty("spotlight_image")
    private String spotlight_image;
    @JsonProperty("spotlight_view_image")
    private String spotlight_view_image;
    @JsonProperty("spotlight_movie_acronym")
    private String spotlight_movie_acronym;
    @JsonProperty("spotlight_action")
    private String spotlight_action;
    @JsonProperty("spotlight_content")
    private String spotlight_content;
    @JsonProperty("spotlight_content_name")
    private String spotlight_content_name;
    @JsonProperty("spotlight_view_action")
    private String spotlight_view_action;
    @JsonProperty("spotlight_view_content")
    private String spotlight_view_content;
    @JsonProperty("connection_timeout")
    private Integer connection_timeout;
    @JsonProperty("socket_timeout")
    private Integer socket_timeout;
    @JsonProperty("song_object_version")
    private String song_object_version;
    @JsonProperty("notification_duration")
    private Integer notification_duration;
    @JsonProperty("app_version")
    private Integer app_version;
    @JsonProperty("radio_spotlight_action")
    private String radio_spotlight_action;
    @JsonProperty("show_radio_roadblock")
    private Boolean show_radio_roadblock;

    @JsonProperty("af_enabled")
    private String af_enabled;
    @JsonProperty("cf_enabled")
    private String cf_enabled;
    @JsonProperty("user_inbox_limit")
    private Integer user_inbox_limit;
    @JsonProperty("carriers_available")
    private String carriers_available;
    @JsonProperty("freemium_skip_limit")
    private Integer freemium_skip_limit;
    @JsonProperty("freemium_skip_interval")
    private Integer freemium_skip_interval;
    @JsonProperty("idleScreenTime")
    private Integer idleScreenTime;
    @JsonProperty("migration")
    private String migration;
    @JsonProperty("jioanalytics")
    private String jioanalytics;
    @JsonProperty("jiotunes_last_updated_at")
    private Integer jiotunes_last_updated_at;
    @JsonProperty("video_data_update")
    private Integer video_data_update;
    @JsonProperty("comscore")
    private String comscore;
    @JsonProperty("give_jio_trial")
    private String give_jio_trial;
    @JsonProperty("madme")
    private String madme;
    @JsonProperty("clevertap")
    private String clevertap;
    @JsonProperty("benefits_enabled")
    private String benefits_enabled;
    @JsonProperty("device_mgmt_enabled")
    private String device_mgmt_enabled;
    @JsonProperty("read_only_mode")
    private Boolean read_only_mode;
    @JsonProperty("server_ts")
    private Integer server_ts;
    @JsonProperty("lib_img_cache")
    private Boolean lib_img_cache;







}
