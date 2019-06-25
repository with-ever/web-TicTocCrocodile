package kr.whenever.crocodile.domain.common.member;

public enum MemberType {
	PARENTS("1", "PARENTS"),
	CROCODILE("2", "CROCODILE"),
	ADMIN("3", "ADMIN");
	
	private String code;
	
	private String name;
	
	private MemberType(String code, String name) {
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
