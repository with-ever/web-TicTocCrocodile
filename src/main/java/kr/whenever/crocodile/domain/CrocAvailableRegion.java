package kr.whenever.crocodile.domain;

public class CrocAvailableRegion {

	private int memberId;
	
	private int regionId;
	
	public CrocAvailableRegion() {}

	public CrocAvailableRegion(int memberId, int regionId) {
		this.memberId = memberId;
		this.regionId = regionId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
}
