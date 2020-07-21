package endPoints;

public enum APIResources {
	
	
	UserLoginAPI ("user.login"),
	UserCreateAPI ("user.createV2"),
	LibraryGetAllAPI ("library.getAll"),
	CreateArtistStation("webradio.createArtistStation"),
	GetSong("webradio.getSong"),
	UserPofileUpdateAPI("user.update");
	
	private String resource;
	
	APIResources(String resource){
		this.resource =resource;
	}
	
	public String getResource() {
		return resource;
	}
	
	

}
