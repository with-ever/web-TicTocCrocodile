package kr.whenever.crocodile.domain;

public class GCMMessage {
	
	private int matchId;
	
	private int matchStatus;
	
	private String message;
	
	public GCMMessage() {}
	
	public GCMMessage(int matchId, int matchStatus) {
		this.matchId = matchId;
		this.matchStatus = matchStatus;
	}

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public int getMatchStatus() {
		return matchStatus;
	}

	public void setMatchStatus(int matchStatus) {
		this.matchStatus = matchStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void createParentMessage(String crocName) {
		this.message = crocName + " 선생님께서 메시지를 보냈습니다";
	}
	
	public void createCrocMessage(String parentName) {
		this.message = parentName + " 학부모님께서 메시지를 보냈습니다";
	}
	
}
