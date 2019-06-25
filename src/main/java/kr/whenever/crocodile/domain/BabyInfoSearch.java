package kr.whenever.crocodile.domain;

import kr.whenever.crocodile.domain.common.PageSearch;

public class BabyInfoSearch extends PageSearch<BabyInfo> {
	
	private int memberId;

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
}
