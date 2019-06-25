package kr.whenever.crocodile.controller.member;

import java.util.HashMap;
import java.util.Map;

import kr.whenever.crocodile.domain.Member;
import kr.whenever.crocodile.domain.MemberSearch;
import kr.whenever.crocodile.service.MemberService;
import kr.whenever.crocodile.util.JSONUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api/v1/members")
public class WSMemberController {
	
	@Autowired
	private MemberService memberService;

	/**
	 * 사용자 목록 조회.
	 * ../api/v1/members?pageNo=1 -> 1페이지 요청.
	 * @param search
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public MemberSearch retrieveMemberListBySearch(
			MemberSearch search
			) {
		MemberSearch memberListBySearch = this.memberService.retrieveMemberListBySearch(search);
		return memberListBySearch;
	}
	
	@RequestMapping(value = "/verification", method = RequestMethod.POST)
	@ResponseBody
	public Member verifyMemberInfo(
			@RequestBody Map<String, Object> requestParam
			) {
		String id = (String) requestParam.get("id");
		String password = (String) requestParam.get("password");
		return this.memberService.verifyMemberInfo(id, password);
	}

	@RequestMapping(value = "/verification/kakao", method = RequestMethod.POST)
	@ResponseBody
	public Member verifyKaKaoMemberInfo(
			@RequestBody Map<String, Object> requestParam
			) {
		String kakaoId = (String) requestParam.get("kakaoId");
		return this.memberService.verifyKaKaoMemberInfo(kakaoId);
	}
	
	@RequestMapping(value = "/password", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String, String> changePassword(
			@RequestBody Map<String, Object> requestParam
			) {
		Map<String, String> result = new HashMap<String, String>();
		String id = (String) requestParam.get("id");
		String password = (String) requestParam.get("password");
		String newPassword = (String) requestParam.get("newPassword");
		int isModified = this.memberService.modifyMemberPassword(id, password, newPassword);
		if (isModified > 0) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
	
	/**
	 * 사용자 조회.
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Member getMember(
			@PathVariable(value = "id") String id
			) {
		Member member = this.memberService.retrieveMember(id);
		return member;
	}
	
	/**
	 * 사용자 등록.
	 * @param user
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> registerMember(
			@RequestBody Map<String, Object> requestParam
			){
		Map<String, String> result = new HashMap<String, String>();
		Member member = JSONUtil.fromJson(JSONUtil.toJson(requestParam), Member.class);
		int memberId = this.memberService.registerMember(member);
		result.put("result", Integer.toString(memberId));
		return result;
	}
	
	/**
	 * 사용자 수정.
	 * ex) 간단한 속성 예제.
	 * param = {
	 * 	type: '1',
	 * 	password: '1234'
	 * }
	 * @param requestParam
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String, String> updateMember(
			@PathVariable(value = "id") String id,
			@RequestBody Map<String, Object> requestParam
			){
		
		Map<String, String> result = new HashMap<String, String>();
		Member updatedMember = JSONUtil.fromJson(JSONUtil.toJson(requestParam), Member.class);
		updatedMember.setId(id);
		this.memberService.modifyMember(updatedMember);
		result.put("result", "success");
		
		return result;
	}
	
	/**
	 * 사용자 삭제.
	 * ex)
	 * param = {
	 * 	pid: '1'
	 * }
	 * @param requestParam
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String, String> removeUser(
			@PathVariable(value = "id") String id
			){
		
		// TODO 고도화 필요.
		Map<String, String> result = new HashMap<String, String>();
		memberService.removeMember(id);
		result.put("result", "success");
		return result;
	}
	
	/**
	 * 사용자 아이디 중복체크.
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}/check", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Integer> checkId(
			@PathVariable(value = "id") String id
			) {
		Map<String, Integer> result = new HashMap<String, Integer>();
		result.put("result", memberService.checkId(id));
		return result;
	}
	
		
}
