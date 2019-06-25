package kr.whenever.crocodile.domain.common.matching;

public enum MatchingStatus {
	
	WAITING(1, "MALE"),
	REJECT(2, "REJECT"),
	CANCEL(3, "CANCEL"),
	ACCEPT(4, "ACCEPT"),
	PAYMENT_COMPLETE(5, "PAYMENT_COMPLETE"),
	SERVICE_COMPLETE(6, "SERVICE_COMPLETE");
	
	private int code;
	
	private String name;
	
	private MatchingStatus(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
