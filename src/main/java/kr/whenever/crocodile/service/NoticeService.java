package kr.whenever.crocodile.service;

import java.util.List;

import kr.whenever.crocodile.domain.Notice;
import kr.whenever.crocodile.domain.NoticeSearch;

public interface NoticeService {
	
	int registerNotice(Notice notice);

	Notice retrieveNotice(int noticeId);
	
	List<Notice> retrieveNoticeList();
	
	NoticeSearch retrieveNoticeListBySearch(NoticeSearch search);
	
	int modifyNotice(Notice notice);
	
	int removeNotice(int noticeId);
	
}
