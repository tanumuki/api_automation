package statusCodes;

public enum StatusCode {
	
	
	OK (200),
	BADREQUEST  (400),
	FORBIDDEN (403),
	REDIRECT (301);
	
	private int code;
	
	private StatusCode(int code){
		this.code =code;
	}
	
	public int getResource() {
		return code;
	}
	
	

}

