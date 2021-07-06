package pojos.videoGetAlbumVideoList;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ArtistMap {

    @JsonProperty("primary_artists")
    public List<PrimaryArtist> primaryArtists = null;
    @JsonProperty("featured_artists")
    public List<Object> featuredArtists = null;
    @JsonProperty("artists")
    public List<Artist> artists = null;

}