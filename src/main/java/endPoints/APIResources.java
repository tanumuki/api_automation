package endPoints;

public enum APIResources {
	
	
	UserLoginAPI ("user.login"),
	UserCreateAPI ("user.createV2"),
	AutocompleteGet ("autocomplete.get");
	
	private String resource;
	
	APIResources(String resource){
		this.resource =resource;
	}
	
	public String getResource() {
		return resource;
	}
	
	

}
