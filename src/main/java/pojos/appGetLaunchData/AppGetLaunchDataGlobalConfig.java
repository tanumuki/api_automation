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
    @JsonProperty("weekly_top_songs_listid")
    private WT15Lists weekly_top_songs_listid;
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
    private String app_version;
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
    @JsonProperty("first_time_user_ad")
    private Boolean first_time_user_ad;
    @JsonProperty("force_https")
    private Boolean forceHttps;
    @JsonProperty("juspay_payment_flow")
    private Boolean juspayPaymentFlow;
    @JsonProperty("show_demographic_modal")
    private Boolean showDemographicModal;
    @JsonProperty("show_language_selection_screen")
    private Boolean showLanguageSelectionScreen;
    @JsonProperty("show_app_language_modal")
    private Boolean show_app_language_modal;
    @JsonProperty("skip_limit")
    private Integer skip_limit;
    @JsonProperty("pro_cta")
    private Deeplink pro_cta;

    @JsonProperty("juspay_paypal_flow")
    private Boolean juspay_paypal_flow;

    //Web release 4-Mar-2021
    @JsonProperty("quick_action")
    private String quick_action;
    @JsonProperty("homepage_tab_order")
    private List<String> homepage_tab_order;

    //Web release 11-Mar-2021
    @JsonProperty("dolby_enabled")
    private String dolby_enabled;

    //Web release 08-April-2021
    @JsonProperty("zero_streamer")
    private Boolean zero_streamer;

    @JsonProperty("video_mapping_data_update")
    private int video_mapping_data_update;

    @JsonProperty("auto_play_exp")
    private AutoPlayExp auto_play_exp;

    @JsonProperty("RateCap_Applicable")
    private Boolean rateCap_Applicable;

    @JsonProperty("Video_Remaining")
    private int video_Remaining;

    @JsonProperty("Max_Video_Limit")
    private int max_Video_Limit;

    @JsonProperty("app_languages")
    private AppLanguages app_languages;

    @JsonProperty("featureViewSpan")
    private int featureViewSpan;

    @JsonProperty("watchVideoSpan")
    private int watchVideoSpan;

    @JsonProperty("in_app_review_stream_count")
    private int in_app_review_stream_count;

    @JsonProperty("module_limit")
    private int module_limit;

    @JsonProperty("module_content_limit")
    private int module_content_limit;

    @JsonProperty("ad_config_ref_time")
    private int ad_config_ref_time;

    @JsonProperty("is_homepod_enabled")
    private Boolean is_homepod_enabled;

    @JsonProperty("isVideoStreamer")
    private Boolean isVideoStreamer;

    @JsonProperty("homepageExpEnabled")
    private Boolean homepageExpEnabled;

    @JsonProperty("homepageExpGraphicEnabled")
    private int homepageExpGraphicEnabled;

    @JsonProperty("juspay_sandbox")
    private Boolean juspaySandbox;

    @JsonProperty("ringtone_enabled")
    private Boolean ringtoneEnabled;

    @JsonProperty("stripe_payment_flow")
    private Boolean stripe_payment_flow;

    @JsonProperty("vendor_order")
    private List<String> vendorOrder;

}
