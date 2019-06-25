package kr.whenever.crocodile.domain;

import kr.whenever.crocodile.domain.common.member.MemberGender;

public class BabyInfo {

	private int babyId;
	
	private int memberId;
	
	private String name;
	
	private int age;
	
	private int gender;
	
	private String imageUrl;
	
	private long createTime;
	
	private long updateTime;
	
	public BabyInfo() {}
	
	public BabyInfo(int memberId) {
		this.memberId = memberId;
		this.createTime = System.currentTimeMillis() / 1000;
		this.updateTime = System.currentTimeMillis() / 1000;
	}

	public int getBabyId() {
		return babyId;
	}

	public void setBabyId(int babyId) {
		this.babyId = babyId;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
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
	
	public void setTimeInfo() {
		this.createTime = System.currentTimeMillis() / 1000;
		this.updateTime = System.currentTimeMillis() / 1000;
	}

	public void setUpdatedBabyInfo(BabyInfo babyInfo) {
		if (babyInfo.getName() != null && !babyInfo.getName().equals("")) this.setName(babyInfo.getName());
		if (babyInfo.getAge() != 0) this.setAge(babyInfo.getAge());
		if (babyInfo.getGender() == Integer.parseInt(MemberGender.MALE.getCode()) || babyInfo.getGender() == Integer.parseInt(MemberGender.FEMALE.getCode())) this.setGender(babyInfo.getGender());
		if (babyInfo.getImageUrl() != null && !babyInfo.getImageUrl().equals("")) this.setImageUrl(babyInfo.getImageUrl());
		this.setUpdateTime(System.currentTimeMillis() / 1000);
	}	
}
