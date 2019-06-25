package kr.whenever.crocodile.domain;

import kr.whenever.crocodile.domain.common.PageSearch;

public class MatchingSearch extends PageSearch<Matching> {
	
	private int contractId;
	
	private int status;
	
	private int parentMemberId;
	
	private int crocMemberId;

	public int getContractId() {
		return contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getParentMemberId() {
		return parentMemberId;
	}

	public void setParentMemberId(int parentMemberId) {
		this.parentMemberId = parentMemberId;
	}

	public int getCrocMemberId() {
		return crocMemberId;
	}

	public void setCrocMemberId(int crocMemberId) {
		this.crocMemberId = crocMemberId;
	}
	
}
