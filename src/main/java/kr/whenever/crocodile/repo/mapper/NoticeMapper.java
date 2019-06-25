package kr.whenever.crocodile.repo.mapper;

import java.util.List;

import kr.whenever.crocodile.domain.Notice;
import kr.whenever.crocodile.domain.NoticeSearch;

public interface NoticeMapper {
	
	int insertNotice(Notice notice);

	Notice selectNotice(int noticeId);

	List<Notice> selectNoticeList();
	
	List<Notice> selectNoticeListBySearch(NoticeSearch search);
	
	int selectNoticeListTotalCount(NoticeSearch search);
	
	int updateNotice(Notice notice);

	int deleteNotice(int noticeId);
}
