package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class ShowMoreInfo {
    @JsonProperty("latest_season_sequence")
    private String latestSeasonSequence;
    @JsonProperty("partner_id")
    private String partnerId;
    @JsonProperty("latest_season_id")
    private String latestSeasonId;
    @JsonProperty("country_of_origin")
    private String countryOfOrigin;
    @JsonProperty("partner_name")
    private String partnerName;
    @JsonProperty("label_id")
    private String labelId;
    @JsonProperty("description")
    private String description;
    @JsonProperty("tags")
    private String tags;
    @JsonProperty("disable_ads")
    private String disableAds;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("followers_count")
    private String followersCount;
    @JsonProperty("parental_advisory")
    private String parentalAdvisory;
    @JsonProperty("is_disabled")
    private String isDisabled;
    @JsonProperty("copyright_text")
    private String copyrightText;
    @JsonProperty("artistMap")
    private ArtistMap artistMap;
    @JsonProperty("header_logo")
    private String headerLogo;
    @JsonProperty("header_color")
    private String headerColor;
    @JsonProperty("header_image")
    private String headerImage;
    @JsonProperty("label")
    private String label;
    @JsonProperty("sort_order")
    private String sortOrder;
    @JsonProperty("square_image")
    private String squareImage;
    @JsonProperty("editors_note")
    private EditorsNote editorsNote;
    @JsonProperty("season_number")
    private String seasonNumber;
    @JsonProperty("total_episodes")
    private String totalEpisodes;
    @JsonProperty("is_followed")
    private String isFollowed;
    @JsonProperty("fan_count")
    private String fanCount;
    @JsonProperty("year")
    private String year;
    @JsonProperty("badge")
    private String badge;
    @JsonProperty("category_tags")
    private List<String> category_tags;
    @JsonProperty("sub_category_tags")
    private List<String> sub_category_tags;
    @JsonProperty("bg_color")
    private String bgColor;

}
