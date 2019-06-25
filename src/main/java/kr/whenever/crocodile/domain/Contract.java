package kr.whenever.crocodile.domain;

public class Contract {

	private int contractId;
	
	private int type;
	
	private Member parentMember;
	
	private BabyInfo babyInfo;
	
	private String title;
	
	private String content;
	
	private String location;
	
	private int status;
	
	private long startTime;
	
	private long endTime;
	
	private long createTime;
	
	private long updateTime;
	
	public Contract() {
		this.createTime = System.currentTimeMillis() / 1000;
		this.updateTime = System.currentTimeMillis() / 1000;
	}
	
	public int getContractId() {
		return contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Member getParentMember() {
		return parentMember;
	}

	public void setParentMember(Member parentMember) {
		this.parentMember = parentMember;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getStartTime() {
		return this.startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return this.endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public long getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public long getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}

	public BabyInfo getBabyInfo() {
		return babyInfo;
	}

	public void setBabyInfo(BabyInfo babyInfo) {
		this.babyInfo = babyInfo;
	}	
	
	public void setTimeInfo() {
		this.createTime = System.currentTimeMillis() / 1000;
		this.updateTime = System.currentTimeMillis() / 1000;
	}
}
