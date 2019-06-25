package kr.whenever.crocodile.domain;

import kr.whenever.crocodile.domain.common.PageSearch;

public class ContractSearch extends PageSearch<Contract> {

	private int type;
	
	private int memberId;
	
	private String title;
	
	private String content;
	
	private int status;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
