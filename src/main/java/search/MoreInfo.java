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

/**
 * @author aswingokulachandran
 *
 */
public class MoreInfo {
	@JsonInclude(JsonInclude.Include.NON_NULL)
//	@JsonPropertyOrder({ "album", "ctr", "score", "primary_artists", "singers", "video_available", "vcode", "vlink" })

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

	@JsonProperty("firstname")
	public String getFirstname() {
		return firstname;
	}

	@JsonProperty("firstname")
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public MoreInfo withFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	@JsonProperty("artist_name")
	public List<String> getArtistName() {
		return artistName;
	}

	@JsonProperty("artist_name")
	public void setArtistName(List<String> artistName) {
		this.artistName = artistName;
	}

	public MoreInfo withArtistName(List<String> artistName) {
		this.artistName = artistName;
		return this;
	}

	@JsonProperty("entity_type")
	public Object getEntityType() {
		return entityType;
	}

	@JsonProperty("entity_type")
	public void setEntityType(Object entityType) {
		this.entityType = entityType;
	}

	public MoreInfo withEntityType(Object entityType) {
		this.entityType = entityType;
		return this;
	}

	@JsonProperty("lastname")
	public String getLastname() {
		return lastname;
	}

	@JsonProperty("lastname")
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public MoreInfo withLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	@JsonProperty("username")
	public String getUsername() {
		return username;
	}

	@JsonProperty("username")
	public void setUsername(String username) {
		this.username = username;
	}

	public MoreInfo withUsername(String username) {
		this.username = username;
		return this;
	}

	@JsonProperty("language")
	public String getLanguage() {
		return language;
	}

	@JsonProperty("language")
	public void setLanguage(String language) {
		this.language = language;
	}

	public MoreInfo withLanguage(String language) {
		this.language = language;
		return this;
	}

	@JsonProperty("uid")
	public Object getUid() {
		return uid;
	}

	@JsonProperty("uid")
	public void setUid(Object uid) {
		this.uid = uid;
	}

	public MoreInfo withUid(Object uid) {
		this.uid = uid;
		return this;
	}

	@JsonProperty("seed")
	public Object getSeed() {
		return seed;
	}

	@JsonProperty("seed")
	public void setSeed(Object seed) {
		this.seed = seed;
	}

	public MoreInfo withSeed(Object seed) {
		this.seed = seed;
		return this;
	}

	@JsonProperty("creation_date")
	public Object getCreationDate() {
		return creationDate;
	}

	@JsonProperty("creation_date")
	public void setCreationDate(Object creationDate) {
		this.creationDate = creationDate;
	}

	public MoreInfo withCreationDate(Object creationDate) {
		this.creationDate = creationDate;
		return this;
	}

	@JsonProperty("featured_station_type")
	public String getFeaturedStationType() {
		return featuredStationType;
	}

	@JsonProperty("featured_station_type")
	public void setFeaturedStationType(String featuredStationType) {
		this.featuredStationType = featuredStationType;
	}

	public MoreInfo withFeaturedStationType(String featuredStationType) {
		this.featuredStationType = featuredStationType;
		return this;
	}

	@JsonProperty("music")
	public String getMusic() {
		return music;
	}

	@JsonProperty("music")
	public void setMusic(String music) {
		this.music = music;
	}

	public MoreInfo withMusic(String music) {
		this.music = music;
		return this;
	}

	@JsonProperty("album")
	public String getAlbum() {
		return album;
	}

	@JsonProperty("album")
	public void setAlbum(String album) {
		this.album = album;
	}

	public MoreInfo withAlbum(String album) {
		this.album = album;
		return this;
	}

	@JsonProperty("ctr")
	public Integer getCtr() {
		return ctr;
	}

	@JsonProperty("ctr")
	public void setCtr(Integer ctr) {
		this.ctr = ctr;
	}

	public MoreInfo withCtr(Integer ctr) {
		this.ctr = ctr;
		return this;
	}

	@JsonProperty("score")
	public String getScore() {
		return score;
	}

	@JsonProperty("score")
	public void setScore(String score) {
		this.score = score;
	}

	public MoreInfo withScore(String score) {
		this.score = score;
		return this;
	}

	@JsonProperty("primary_artists")
	public String getPrimaryArtists() {
		return primaryArtists;
	}

	@JsonProperty("primary_artists")
	public void setPrimaryArtists(String primaryArtists) {
		this.primaryArtists = primaryArtists;
	}

	public MoreInfo withPrimaryArtists(String primaryArtists) {
		this.primaryArtists = primaryArtists;
		return this;
	}

	@JsonProperty("singers")
	public String getSingers() {
		return singers;
	}

	@JsonProperty("singers")
	public void setSingers(String singers) {
		this.singers = singers;
	}

	public MoreInfo withSingers(String singers) {
		this.singers = singers;
		return this;
	}

	@JsonProperty("video_available")
	public Boolean getVideoAvailable() {
		return videoAvailable;
	}

	@JsonProperty("video_available")
	public void setVideoAvailable(Boolean videoAvailable) {
		this.videoAvailable = videoAvailable;
	}

	public MoreInfo withVideoAvailable(Boolean videoAvailable) {
		this.videoAvailable = videoAvailable;
		return this;
	}

	@JsonProperty("vcode")
	public String getVcode() {
		return vcode;
	}

	@JsonProperty("vcode")
	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

	public MoreInfo withVcode(String vcode) {
		this.vcode = vcode;
		return this;
	}

	@JsonProperty("vlink")
	public String getVlink() {
		return vlink;
	}

	@JsonProperty("vlink")
	public void setVlink(String vlink) {
		this.vlink = vlink;
	}

	public MoreInfo withVlink(String vlink) {
		this.vlink = vlink;
		return this;
	}

}
