package kr.whenever.crocodile.service.impl;

import java.util.List;

import kr.whenever.crocodile.domain.Notice;
import kr.whenever.crocodile.domain.NoticeSearch;
import kr.whenever.crocodile.service.NoticeService;
import kr.whenever.crocodile.repo.NoticeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeRepository noticeRepository;
	
	@Override
	public int registerNotice(Notice notice) {		
		return this.noticeRepository.registerNotice(notice);
	}

	@Override
	public Notice retrieveNotice(int noticeId) {
		return this.noticeRepository.retrieveNotice(noticeId);
	}

	@Override
	public List<Notice> retrieveNoticeList() {
		return this.noticeRepository.retrieveNoticeList();
	}
	
	@Override
	public NoticeSearch retrieveNoticeListBySearch(NoticeSearch search) {
		return this.noticeRepository.retrieveNoticeListBySearch(search);
	}

	@Override
	public int modifyNotice(Notice notice) {
		return this.noticeRepository.modifyNotice(notice);
	}

	@Override
	public int removeNotice(int noticeId) {
		return this.noticeRepository.removeNotice(noticeId);
	}

	

}
