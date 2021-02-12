package pojos.appGetLaunchData;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pojos.getHomePageDataV2.HomePageDataModules;
import pojos.getHomePageDataV2.HomePageDataV2;
import pojos.getTopShows.TopShows;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class AppGetLaunchData extends HomePageDataV2 {
    @JsonProperty("app_version")
    private String appVersion;
    @JsonProperty("update_config")
    private UpdateConfig updateConfig;
    @JsonProperty("ab_test")
    private Object abTest;
    @JsonProperty("ef")
    private List<String> ef = null;
    @JsonProperty("ab_test_exp")
    private List<String> abTestExp = null;
    @JsonProperty("ping_server")
    private String pingServer;
    @JsonProperty("top_searches")
    private List<TopSearch> topSearches;
    @JsonProperty("loginwall")
    private String loginwall;
    @JsonProperty("jiologinwall")
    private String jiologinwall;
    @JsonProperty("ads")
    private Ads ads;
    @JsonProperty("modules")
    private HomePageDataModules modules;
    @JsonProperty("device_status")
    private String deviceStatus;
    @JsonProperty("global_config")
    private AppGetLaunchDataGlobalConfig global_config;
    @JsonProperty("deferred_login_config")
    private DeferredLoginConfigWrapper deferred_login_config;


}
