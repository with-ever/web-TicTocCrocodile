package kr.whenever.crocodile.domain.common.contract;

public enum ContractStatus {
	
	REQUEST(1, "MALE"),
	MATCHING_COMPLETE(2, "REJECT"),
	SERVICE_COMPLETE(3, "CANCEL");
	
	private int code;
	
	private String name;
	
	private ContractStatus(int code, String name) {
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
