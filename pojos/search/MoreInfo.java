/**
 * 
 */
package search;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author aswingokulachandran
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
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
	private Object uid;
	
	@JsonProperty("seed")
	private Object seed;
	
	@JsonProperty("creation_date")
	private Object creationDate;
	
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

	
}
