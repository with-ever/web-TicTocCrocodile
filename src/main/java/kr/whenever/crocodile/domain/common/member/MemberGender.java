package kr.whenever.crocodile.domain.common.member;

public enum MemberGender {
	
	MALE("1", "MALE"),
	FEMALE("2", "FEMALE");
	
	private String code;
	
	private String name;
	
	private MemberGender(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
