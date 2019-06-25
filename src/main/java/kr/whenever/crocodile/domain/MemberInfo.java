package kr.whenever.crocodile.domain;

import java.util.List;

public class MemberInfo {
	
	// Member.memberId
	private int memberId;
	
	private String name;
	
	private int gender;
	
	private String tel;
	
	private String addr;
	
	private String imageUrl;
	
	private long createTime;
	
	private long updateTime;
	
	private List<BabyInfo> babyInfo;

	public MemberInfo() {}
	
	public MemberInfo(int memberId) {
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
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
	
	public List<BabyInfo> getBabyInfo() {
		return babyInfo;
	}
	
	public void setBabyInfo(List<BabyInfo> babyInfo) {
		this.babyInfo = babyInfo;
	}
	
	/**
	 * 업데이트 될 사용자 정보를 세팅한다.
	 * updatedMemberInfo -> this MemberInfo
	 * @param updatedMemberInfo 업데이트 될 값을 가지고 있는 사용자 정보.
	 */
	public void setUpdatedMemberInfo(MemberInfo updatedMemberInfo) {
		this.setName(updatedMemberInfo.getName());
		this.setGender(updatedMemberInfo.getGender());
		this.setTel(updatedMemberInfo.getTel());
		this.setAddr(updatedMemberInfo.getAddr());
		this.setImageUrl(updatedMemberInfo.getImageUrl());
		this.setUpdateTime(System.currentTimeMillis() / 1000);
	}
	
}
