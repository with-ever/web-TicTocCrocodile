package kr.whenever.crocodile.repo;

import kr.whenever.crocodile.domain.Notice;
import kr.whenever.crocodile.domain.NoticeSearch;
import kr.whenever.crocodile.repo.mapper.NoticeMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeRepository {
	
	@Autowired
	private NoticeMapper noticeMapper;

	public int registerNotice(Notice notice) {
		return this.noticeMapper.insertNotice(notice);
	}
	
	public Notice retrieveNotice(int noticeId) {
		return this.noticeMapper.selectNotice(noticeId);
	}
	
	public List<Notice> retrieveNoticeList() {
		return this.noticeMapper.selectNoticeList();
	}
	
	public NoticeSearch retrieveNoticeListBySearch(NoticeSearch search) {
		List<Notice> notices = this.noticeMapper.selectNoticeListBySearch(search);
		search.setResults(notices);
		
		if (notices.size() != 0) {
			int totalCount = this.noticeMapper.selectNoticeListTotalCount(search);
			search.setTotalCount(totalCount);
		}
		return search;
	}
	
	public int modifyNotice(Notice notice) {
		return this.noticeMapper.updateNotice(notice); 
	}

	public int removeNotice(int noticeId) {
		return this.noticeMapper.deleteNotice(noticeId);
	}


}
