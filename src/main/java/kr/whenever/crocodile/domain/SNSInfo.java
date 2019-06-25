package kr.whenever.crocodile.domain;

public class SNSInfo {
	
	private int idx;
	
	private int memberId;
	
	private String snsId;
	
	private int snsType;
	
	public SNSInfo() {}
	
	public SNSInfo(int memberId, String snsId, int snsType) {
		this.memberId = memberId;
		this.snsId = snsId;
		this.snsType = snsType;
	}
	
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getSnsId() {
		return snsId;
	}

	public void setSnsId(String snsId) {
		this.snsId = snsId;
	}

	public int getSnsType() {
		return snsType;
	}

	public void setSnsType(int snsType) {
		this.snsType = snsType;
	}

}
