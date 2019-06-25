package kr.whenever.crocodile.domain.common;

public enum UserIdentifiedType {
	//
	SUCCESS("0", "SUCCESS"),
	FAIL("1", "FAIL"),
	NONEXISTENCE("2", "NONEXISTENCE");
	
	private String code;
	
	private String name;
	
	private UserIdentifiedType(String code, String name) {
		//
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
	
}
