package kr.whenever.crocodile.domain;

public class GCMInfo {
	
	private int idx;
	
	private int memberId;
	
	private String gcmId;
	
	private String deviceId;
	
	public GCMInfo() {}
	
	public GCMInfo(int memberId, String gcmId, String deviceId) {
		this.memberId = memberId;
		this.gcmId = gcmId;
		this.deviceId = deviceId;
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

	public String getGcmId() {
		return gcmId;
	}

	public void setGcmId(String gcmId) {
		this.gcmId = gcmId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
}
