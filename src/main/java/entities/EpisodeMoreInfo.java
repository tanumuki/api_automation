package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pojos.SearchGetEntityResults.ArtistResultObj;

import java.util.List;
@Data
@Getter
@Setter
public class EpisodeMoreInfo {

    @JsonProperty("duration")
    private String duration;
    @JsonProperty("weight")
    private String weight;
    @JsonProperty("geo_rules")
    private List<Integer> geoRules = null;
    @JsonProperty("square_image_url")
    private String squareImageUrl;
    @JsonProperty("label_id")
    private String labelId;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("entity_title_exact_match")
    private String entity_title_exact_match;
    @JsonProperty("description")
    private String description;
    @JsonProperty("bg_color")
    private String bg_color;
    @JsonProperty("season_no")
    private String seasonNo;
    @JsonProperty("sequence_number")
    private String sequence_number;
    @JsonProperty("season_number")
    private String seasonNumber;
    @JsonProperty("show_id")
    private String showId;
    @JsonProperty("season_id")
    private String seasonId;
    @JsonProperty("show_title")
    private String showTitle;
    @JsonProperty("season_title")
    private String seasonTitle;
    @JsonProperty("square_image")
    private String squareImage;
    @JsonProperty("artistMap")
    private ArtistMap artistMap;
    @JsonProperty("episode_number")
    private String episodeNumber;
    @JsonProperty("label")
    private String label;
    @JsonProperty("origin")
    private String origin;
    @JsonProperty("ad_breaks")
    private String adBreaks;
    @JsonProperty("rights")
    private Rights rights;
    @JsonProperty("starred")
    private String starred;
    @JsonProperty("cache_state")
    private String cacheState;
    @JsonProperty("show_url")
    private String showUrl;
    @JsonProperty("encrypted_media_url")
    private String encryptedMediaUrl;
    @JsonProperty("genre_tags")
    private List<String> genre_tags;
    @JsonProperty("seasonality_tags")
    private List<String> seasonality_tags;
    @JsonProperty("multi_br")
    private String multiBr;
    @JsonProperty("album")
    private String album;
    @JsonProperty("primary_artists")
    private List<ArtistResultObj> primary_artists;
    @JsonProperty("release_time")
    private String releaseTime;

}
