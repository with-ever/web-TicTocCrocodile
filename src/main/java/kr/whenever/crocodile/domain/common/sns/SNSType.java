package kr.whenever.crocodile.domain.common.sns;

public enum SNSType {
	
	KAKAO(1, "KAKAO");
	
	private int code;
	
	private String name;
	
	private SNSType(int code, String name) {
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
