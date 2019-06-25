package kr.whenever.crocodile.controller.admin;

import kr.whenever.crocodile.domain.Member;
import kr.whenever.crocodile.domain.MemberSearch;
import kr.whenever.crocodile.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin/croc")
public class AdminCrocController {
	
	@Autowired
	private MemberService memberService;

	/**
	 * 악어 목록 조회.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView showCrocMemberList(
			MemberSearch search
			) {
		ModelAndView mav = new ModelAndView();
		search.setType(2);
		MemberSearch memberListBySearch = this.memberService.retrieveMemberListBySearch(search);
		mav.addObject("searchModel", memberListBySearch);
		mav.setViewName("/admin/showCrocMemberList");
		return mav;
	}
	
	/**
	 *악어 등록 화면
	 */
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public ModelAndView showCrocMemberRegistForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/registCrocMember");
		return mav;
	}
	
	/**
	 * 악어 등록
	 * @param member
	 * @return
	 */
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView registerCrocMember(
			@ModelAttribute Member member
			) {
		member.setType(1);
		int memberId = this.memberService.registerMember(member);
		ModelAndView mav = new ModelAndView();
		mav.addObject("memberId", memberId);
		mav.setViewName("redirect:/admin/croc/addInfo");
		return mav;
	}
	
	/**
	 *악어 부가정보 입력 화면
	 */
	@RequestMapping(value="/addInfo", method=RequestMethod.GET)
	public ModelAndView showCrocMemberAddInfoForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/registCrocMemberInfo");
		return mav;
	}
	
	/**
	 *악어 상세 정보 화면
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView showCrocMemberView(
			@PathVariable(value = "id") String id
			) {
		ModelAndView mav = new ModelAndView();
		Member member = this.memberService.retrieveMember(id);
		mav.addObject("searchModel", member);
		mav.setViewName("/admin/showCrocMember");
		return mav;
	}
	
	
	/**
	 *악어 수정 화면
	 */
	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView showCrocMemberModifyForm(
			@PathVariable(value = "id") String id
			) {
		ModelAndView mav = new ModelAndView();
		Member member = this.memberService.retrieveMember(id);
		mav.addObject("searchModel", member);
		mav.setViewName("/admin/modifyCrocMember");
		return mav;
	}
	
	/**
	 *악어 수정
	 */
	@RequestMapping(value="/{id}/edit", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView modifyCrocMember(
			@PathVariable(value = "id") String id,
			@ModelAttribute Member member
			) {
		ModelAndView mav = new ModelAndView();
		this.memberService.modifyMember(member);
		mav.setViewName("redirect:/admin/croc/{id}/edit");
		return mav;
	}
	
	/*
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView registerUser(
			User user
			) {
		//
		this.userService.registerUser(user);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/user/list");
		return mav;
	}
	*/
}
