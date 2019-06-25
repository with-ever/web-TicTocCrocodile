package kr.whenever.crocodile.domain;


public class User {
	
	private Long pid;
	
	private String uid;
	
	private	String password;
	
	private String nickname;
	
	private String cellPhoneNo;
		
	private String birthDate;
	
	private String school;
	
	private String type;
	
	private String token;
	
	public User() {}
	
	public User(String uid, String cellPhoneNo) {
		this.uid = uid;
		this.cellPhoneNo = cellPhoneNo;
	}
	
	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getCellPhoneNo() {
		return cellPhoneNo;
	}

	public void setCellPhoneNo(String cellPhoneNo) {
		this.cellPhoneNo = cellPhoneNo;
	}
	
	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	/**
	 * 업데이트 될 사용자 정보를 세팅한다.
	 * updatedUser -> this User
	 * @param updatedUser 업데이트 될 값을 가지고 있는 사용자 정보.
	 */
	public void setUpdatedUserInfo(User updatedUser) {
		setNickname(updatedUser.getNickname());
		setCellPhoneNo(updatedUser.cellPhoneNo);
		setBirthDate(updatedUser.birthDate);
		setType(updatedUser.getType());
	}
}
