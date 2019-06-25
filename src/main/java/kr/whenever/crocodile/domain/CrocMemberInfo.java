package kr.whenever.crocodile.domain;

import java.util.List;

public class CrocMemberInfo {
	
	// Member.memberId
	private int memberId;
	
	private int level;
	
	private String name;
	
	private int gender;
	
	private String univ;
	
	private String major;
	
	private String tel;
	
	private String email;
	
	private String description;
	
	private String imageUrl;
	
	private long createTime;
	
	private long updateTime;
	
	private List<CrocAvailableRegion> crocAvailableRegions;
	
	private List<CrocAvailableTime> crocAvailableTimes;
	
	private List<CrocAvailableService> crocAvailableServices;
	
	public CrocMemberInfo() {}
	
	public CrocMemberInfo(int memberId) {
		this.memberId = memberId;
		this.createTime = System.currentTimeMillis() / 1000;
		this.updateTime = System.currentTimeMillis() / 1000;
	}
	
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getUniv() {
		return univ;
	}

	public void setUniv(String univ) {
		this.univ = univ;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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
	
	public List<CrocAvailableRegion> getCrocAvailableRegions() {
		return crocAvailableRegions;
	}

	public void setCrocAvailableRegions(List<CrocAvailableRegion> crocAvailableRegions) {
		this.crocAvailableRegions = crocAvailableRegions;
	}

	public List<CrocAvailableTime> getCrocAvailableTimes() {
		return crocAvailableTimes;
	}

	public void setCrocAvailableTimes(List<CrocAvailableTime> crocAvailableTimes) {
		this.crocAvailableTimes = crocAvailableTimes;
	}
	
	public List<CrocAvailableService> getCrocAvailableServices() {
		return crocAvailableServices;
	}

	public void setCrocAvailableServices(List<CrocAvailableService> crocAvailableServices) {
		this.crocAvailableServices = crocAvailableServices;
	}

	/**
	 * 업데이트 될 악어사용자 정보를 세팅한다.
	 * updatedCrocMemberInfo -> this CrocMemberInfo
	 * @param updatedCrocMemberInfo 업데이트 될 값을 가지고 있는 사용자 정보.
	 */
	public void setUpdatedCrocMemberInfo(CrocMemberInfo updatedCrocMemberInfo) {
		this.setLevel(updatedCrocMemberInfo.getLevel());
		this.setName(updatedCrocMemberInfo.getName());
		this.setGender(updatedCrocMemberInfo.getGender());
		this.setUniv(updatedCrocMemberInfo.getUniv());
		this.setMajor(updatedCrocMemberInfo.getMajor());
		this.setTel(updatedCrocMemberInfo.getTel());
		this.setEmail(updatedCrocMemberInfo.getEmail());
		this.setDescription(updatedCrocMemberInfo.getDescription());
		this.setImageUrl(updatedCrocMemberInfo.getImageUrl());
		this.setUpdateTime(System.currentTimeMillis() / 1000);
	}

}
