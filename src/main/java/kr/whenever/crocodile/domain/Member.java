package kr.whenever.crocodile.domain;

public class Member {

	// private id, auto increment
	private int memberId;
	
	private String id;
	
	private int type;
	
	private String password;
	
	private MemberInfo memberInfo;
	
	private CrocMemberInfo crocMemberInfo;
	
	private SNSInfo snsInfo;
	
	private long createTime;
	
	private long updateTime;
	
	public Member() {}
	
	public Member(String id, int type, String password) {
		this.id = id;
		this.type = type;
		// TODO password 암호화
		this.password = password;
		this.createTime = System.currentTimeMillis() / 1000;
		this.updateTime = System.currentTimeMillis() / 1000;
	}
	
	
	
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MemberInfo getMemberInfo() {
		return memberInfo;
	}

	public void setMemberInfo(MemberInfo memberInfo) {
		this.memberInfo = memberInfo;
	}

	public CrocMemberInfo getCrocMemberInfo() {
		return crocMemberInfo;
	}

	public void setCrocMemberInfo(CrocMemberInfo crocMemberInfo) {
		this.crocMemberInfo = crocMemberInfo;
	}
	
	public SNSInfo getSnsInfo() {
		return snsInfo;
	}

	public void setSnsInfo(SNSInfo snsInfo) {
		this.snsInfo = snsInfo;
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

	/**
	 * 업데이트 될 사용자 정보를 세팅한다.
	 * updatedMember -> this Member
	 * @param updatedMember 업데이트 될 값을 가지고 있는 사용자 정보.
	 */
	public void setUpdatedMember(Member updatedMember) {
		this.setPassword(updatedMember.getPassword());
		this.setUpdateTime(System.currentTimeMillis() / 1000);
	}
	
}
