package kr.whenever.crocodile.domain;

public class Matching {
	
	private int matchId;
	
	private int contractId;
	
	private Contract contract;
	
	private Member crocMember;
	
	private long startTime;
	
	private long endTime;
	
	private int status;
	
	private String etc;
	
	private long createTime;
	
	private long updateTime;
	
	public Matching() {
		this.createTime = System.currentTimeMillis() / 1000;
		this.updateTime = System.currentTimeMillis() / 1000;
	}
	
	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public int getContractId() {
		return contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}
	
	public Member getCrocMember() {
		return crocMember;
	}

	public void setCrocMember(Member crocMember) {
		this.crocMember = crocMember;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
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
	
	public void setTimeInfo() {
		this.createTime = System.currentTimeMillis() / 1000;
		this.updateTime = System.currentTimeMillis() / 1000;
	}

}
