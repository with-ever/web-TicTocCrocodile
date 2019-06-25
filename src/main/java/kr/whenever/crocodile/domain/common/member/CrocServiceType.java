package kr.whenever.crocodile.domain.common.member;

public enum CrocServiceType {

	// 등하교 
	SCHOOL(1, "SCHOOL"),
	// 돌봄
	CARE(2, "CARE"),
	// 체험
	PLAY(3, "PLAY");
	
	private int code;
	
	private String name;
	
	private CrocServiceType(int code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
}
