/**
 * 
 */
package pojos.Artist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ashwinsriv
 *
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Data
public class SimilarArtists {

	@JsonProperty("_id")
	private String _id;
	@JsonProperty("id")
	private String id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("bio")
	private String bio;
	@JsonProperty("roles")
	private String roles;
	@JsonProperty("aka")
	private String aka;
	@JsonProperty("fb")
	private String fb;
	@JsonProperty("twitter")
	private String twitter;
	@JsonProperty("wiki")
	private String wiki;
	@JsonProperty("similar")
	private String similar;
	@JsonProperty("dob")
	private String dob;
	@JsonProperty("image_url")
	private String image_url;
	@JsonProperty("search_keywords")
	private String search_keywords;
	@JsonProperty("primary_artist_id")
	private String primary_artist_id;
	@JsonProperty("combine_artist_pages")
	private String combine_artist_pages;
	@JsonProperty("isVerified")
	private String isVerified;
	@JsonProperty("replace_with_primary_artists")
	private String replace_with_primary_artists;
	@JsonProperty("languages")
	private String languages;
	@JsonProperty("perma_url")
	private String perma_url;
	@JsonProperty("type")
	private String type;
	@JsonProperty("mini_obj")
	private String mini_obj;
	@JsonProperty("isRadioPresent")
	private String isRadioPresent;
	@JsonProperty("dominantType")
	private String dominantType;
}
