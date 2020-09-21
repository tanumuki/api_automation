package endPoints;

public enum APIResources {

    MixGetDetails("mix.getDetails"),
    MixesList("mix.list"),
    ContentGetAlbums("content.getAlbums"),
    GetHomepageDataV2("content.getHomepageDataV2"),
    ContentGetListeningHistory("content.getListeningHistory"),
    ContentGetTrending("content.getTrending"),
    ChannelGetDetailsAPI("channel.getDetails"),
    SearchGetArtistResults("search.getArtistResults"),
    ContentGetTopShows("content.getTopShows"),
    ShowGetAllEpisodes("show.getAllEpisodes"),
    GetFeaturedPlaylistAPI("content.getFeaturedPlaylists"),
    GetAllChartsAPI("content.getCharts"),
    ShowGetHomePage("show.getHomePage"),
    GetAllChannelsAPI("channel.getAllChannels"),
    GetPlaylistDetailsAPI("playlist.getDetails"),
    GetAlbumDetailsAPI("content.getAlbumDetails"),
    AutocompleteGet("autocomplete.get"),
    UserLoginAPI("user.login"),
    UserCreateAPI("user.createV2"),
    LibraryAddAPI("library.add"),
    SocialFollowAPI("social.follow"),
    LibraryGetAllAPI("library.getAll"),
    CreateArtistStation("webradio.createArtistStation"),
    WebRadioGetSong("webradio.getSong"),
    GetSong("webradio.getSong"),
    UserProfileUpdateAPI("user.update"),
    UserGetProfileAPI("user.getDetails"),
    ContentGetAlbumDetails("content.getAlbumDetails"),
    LibraryDelete("library.delete"),
    GetArtistPageDetailsAPI("artist.getArtistPageDetails"),
    GetArtistMoreSongs("artist.getArtistMoreSong"),
    GetArtistMoreAlbums("artist.getArtistMoreAlbum"),
    GetArtistSimilarArtists("artist.getSimilarArtists"),
    PlaylistCreate("playlist.create"),
    UserLogoutAPI("user.logout"),
	WebRadioCreateEntityStation("webradio.createEntityStation"),
	WebRadioCreateStation("webradio.createStation");

    private String resource;

    APIResources(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }


}
