package kr.whenever.crocodile.domain;

public class CrocAvailableService {
	private int memberId;
	
	private int serviceId;
	
	public CrocAvailableService() {}
	
	public CrocAvailableService(int memberId, int serviceId) {
		this.memberId = memberId;
		this.serviceId = serviceId;
	}
	
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	
	
}
