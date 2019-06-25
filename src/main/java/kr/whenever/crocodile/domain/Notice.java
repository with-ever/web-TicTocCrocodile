package kr.whenever.crocodile.domain;

public class Notice {
	
	private int noticeId;
	
	private String title;
	
	private String content;
	
	private int adminId;
	
	private long createTime;
	
	private long updateTime;
	
	public Notice() {
		this.createTime = System.currentTimeMillis() / 1000;
		this.updateTime = System.currentTimeMillis() / 1000;
	}

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
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

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
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

}
