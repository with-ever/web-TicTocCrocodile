package kr.whenever.crocodile.controller.admin;

import kr.whenever.crocodile.domain.Member;
import kr.whenever.crocodile.domain.MemberSearch;
import kr.whenever.crocodile.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin/parent")
public class AdminParentController {
	
	@Autowired
	private MemberService memberService;
	
	/**
	 * 학부모 목록 조회.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView showParentList(
			MemberSearch search
			) {
		ModelAndView mav = new ModelAndView();
		search.setType(1);
		MemberSearch memberListBySearch = this.memberService.retrieveMemberListBySearch(search);
		mav.addObject("searchModel", memberListBySearch);
		mav.setViewName("/admin/showParentList");
		return mav;
	}
	
	/**
	 *학부모 상세 정보 화면
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView showParentMemberView(
			@PathVariable(value = "id") String id
			) {
		ModelAndView mav = new ModelAndView();
		Member member = this.memberService.retrieveMember(id);
		mav.addObject("searchModel", member);
		mav.setViewName("/admin/showParent");
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
