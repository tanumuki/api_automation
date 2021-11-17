package enums;

public enum StatusCode {
	
	
	OK (200),
	BADREQUEST  (400),
	FORBIDDEN (403),
	REDIRECT (301),
	CREATED (201);
	
	private int code;
	
	 StatusCode(int code){
		this.code =code;
	}
	
	public int getResource() {
		return code;
	}
	
	

}

