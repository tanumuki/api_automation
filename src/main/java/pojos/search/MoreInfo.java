/**
 * 
 */
package pojos.search;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author aswingokulachandran
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@ToString
@Data
public class MoreInfo {
	

	@JsonProperty("music")
	private String music;
	
	@JsonProperty("album")
	private String album;
	
	@JsonProperty("ctr")
	private Integer ctr;
	
	@JsonProperty("score")
	private String score;
	
	@JsonProperty("primary_artists")
	private String primaryArtists;
	
	@JsonProperty("singers")
	private String singers;
	
	@JsonProperty("video_available")
	private Boolean videoAvailable;
	
	@JsonProperty("vcode")
	private String vcode;
	
	@JsonProperty("vlink")
	private String vlink;

	@JsonProperty("username")
	private String username;
	
	@JsonProperty("language")
	private String language;
	
	@JsonProperty("uid")
	private String uid;
	
	@JsonProperty("seed")
	private String seed;
	
	@JsonProperty("creation_date")
	private String creationDate;
	
	@JsonProperty("featured_station_type")
	private String featuredStationType;

	@JsonProperty("firstname")
	private String firstname;
	
	@JsonProperty("artist_name")
	private List<String> artistName = null;
	
	@JsonProperty("entity_type")
	private Object entityType;
	
	@JsonProperty("lastname")
	private String lastname;
	
	@JsonProperty("is_movie")
	private String is_movie;

	@JsonProperty("year")
	private String year;
	
	@JsonProperty("song_pids")
	private String song_pids;
	
	@JsonProperty("season_number")
	private int season_number;
}
