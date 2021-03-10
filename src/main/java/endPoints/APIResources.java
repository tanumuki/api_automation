package endPoints;

public enum APIResources {

	SEOgetMetaResponse("seo.getMetaResponse"),
	ContentGetReplay("content.getReplay"),
	SubscriptionCheckRights("subscription.checkRights"),
	GetUserCurrSubscription("subscription.getUserCurrentSubscription"),
	SubscriptionGetStatus("subscription.getStatus"),
	GetContentRightsChanged("subscription.contentRightsChanged"),
	SearchGetResults("search.getResults"),
	SearchGetMoreResults("search.getMoreResults"),
	SearchGetPlaylistResults("search.getPlaylistResults"),
	SearchGetAlbumResults("search.getAlbumResults"),
	JTGetMoreTrendingSongs("jiotunepage.getMoreTrendingSongs"),
	JTGetMoreSongs("jiotunepage.getMoreSongs"),
	JiotuneGetHomepageData("jiotunepage.getHomepageData"),
	SubsGetAuthorizedDevices("subscription.getAuthorizedDevices"),
	GetSongReco("reco.getreco"),
	SearchTabHomePage("search_tab.getsearchhomepage"),
	ReceiptGetDetails("receipt.getDetails"),
	GetPlaylistRecoAPI("reco.getPlaylistReco"),
	GetAlbumRecoAPI("reco.getAlbumReco"),
	ReceiptList("receipt.list"),
	PodcastGetNT("podcast.getNewandTrending"),
	PodcastGetMoreData("podcast.getMoreData"),
	PodcastGetCategory("podcast.getCategory"),
	PodcastGetAllCategories("podcast.getAllCategories"),
	PodcastGetAll("podcast.getAll"),
	BrowseGetAll("browse.getAll"),
	AppGetLaunchData("app.getLaunchData"),
	ShowGetEpisodeDetails("show.getEpisodeDetails"),
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
	UserLoginAPI ("user.login"),
	UserCreateAPI ("user.createV2"),
	LibraryAddAPI ("library.add"),
	SocialFollowAPI ("social.follow"),
	SocialUnfollowAPI("social.unfollow"),
	LibraryGetAllAPI ("library.getAll"),
	CreateArtistStation("webradio.createArtistStation"),
	WebRadioGetSong("webradio.getSong"),
	WebRadioGetFeaturedStation("webradio.getFeaturedStations"),
	WebRadioCreateFeaturedStation("webradio.createFeaturedStation"),
	GetSong("webradio.getSong"),
	UserProfileUpdateAPI("user.update"),
	UserGetProfileAPI("user.getDetails"),
	ContentGetAlbumDetails ("content.getAlbumDetails"),
	LibraryDelete("library.delete"),
	GetArtistPageDetailsAPI("artist.getArtistPageDetails"),
	GetArtistMoreSongs("artist.getArtistMoreSong"),
	GetArtistMoreAlbums("artist.getArtistMoreAlbum"),
	GetArtistSimilarArtists("artist.getSimilarArtists"),
	PlaylistCreate("playlist.create"),
	UserLogoutAPI("user.logout"),
	WebRadioCreateEntityStation("webradio.createEntityStation"),
	WebRadioCreateStation("webradio.createStation"),
	WebRadioCreateFavouriteStation("webradio.createFeaturedStation"),
	BenefitsCountApi("benefits.count"),
	BenefitsListApi("benefits.list"),
	AppGetLaunchDataJioPhone("app.getLaunchDataJioPhone"),
	SearchGetResultsFromEntities("search.getResultsFromEntities"),
	ContentGetTopSearches("content.getTopSearches"),
	UserChangePasswordApi("user.changePassword"),
	SongGetParamsApi("song.getParam"),
	ContentDecodeTokenAndFetchResults("content.decodeTokenAndFetchResults"),
	JioSendOtpApi("jio.sendOtp"),
	JioTuneLimitApi("jiotune.jioTuneLimit"),
	MatchingMatchApi("matching.match");


	private String resource;

	APIResources(String resource){
		this.resource =resource;
	}

	public String getResource() {
		return resource;
	}



}
