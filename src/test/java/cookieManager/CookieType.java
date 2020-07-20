package cookieManager;

public enum CookieType {
	
	
	
	hindi ("hindi"),
	english ("english"),
	tamil ("tamil"),
	telugu ("telugu");
	
	private String cookie;
	
	CookieType(String cookie){
		this.cookie =cookie;
	}
	
	public String getCookie() {
		return cookie;
	}
	
	

}
