package kr.whenever.crocodile.controller.notice;

import java.util.HashMap;
import java.util.Map;

import kr.whenever.crocodile.domain.Notice;
import kr.whenever.crocodile.domain.NoticeSearch;
import kr.whenever.crocodile.service.NoticeService;
import kr.whenever.crocodile.util.JSONUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api/v1/notices")
public class WSNoticeController {
	
	@Autowired
	private NoticeService noticeService;

	/**
	 * 공지사항 목록 조회.
	 * ../ws/notices?pageNo=1 -> 1페이지 요청.
	 * @param search
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public NoticeSearch getNoticeListBySearch(
			NoticeSearch search
			) {
		NoticeSearch noticeListBySearch = noticeService.retrieveNoticeListBySearch(search);
		return noticeListBySearch;
	}
	
	/**
	 * 공지사항 조회.
	 * @param noticeId
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Notice getNotice(
			@PathVariable(value = "id") int noticeId
			) {
		Notice notice = this.noticeService.retrieveNotice(noticeId);
		return notice;
	}
	
	/**
	 * 공지사항 등록.
	 * @param notice
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> registerNotice(
			Notice notice
			){
		Map<String, String> result = new HashMap<String, String>();
		int noticeId = this.noticeService.registerNotice(notice);
		result.put("result", Integer.toString(noticeId));
		return result;
	}
	
	/**
	 * 공지사항 수정
	 * @param requestParam
	 * @return
	 */
	@RequestMapping(value = "/{noticeId}", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String, String> updateNotice(
			@PathVariable(value = "noticeId") int noticeId,
			@RequestBody Map<String, Object> requestParam
			){
		Map<String, String> result = new HashMap<String, String>();
		Notice updatedNotice = JSONUtil.fromJson(JSONUtil.toJson(requestParam), Notice.class);
		updatedNotice.setNoticeId(noticeId);
		this.noticeService.modifyNotice(updatedNotice);
		result.put("result", "success");
		
		return result;
	}
	
	/**
	 * 공지사항 삭제.
	 * @param requestParam
	 * @return
	 */
	@RequestMapping(value ="/{noticeId}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String, String> removeNotice(
			@PathVariable(value = "noticeId") int noticeId,
			@RequestBody Map<String, Object> requestParam
			){
		Map<String, String> result = new HashMap<String, String>();
		noticeService.removeNotice(noticeId);
		result.put("result", "success");
		return result;
	}
}
