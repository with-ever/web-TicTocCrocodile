package kr.whenever.crocodile.controller;

import javax.servlet.http.HttpSession;

import kr.whenever.crocodile.domain.Member;
import kr.whenever.crocodile.domain.common.member.MemberType;
import kr.whenever.crocodile.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RootController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(HttpSession session) {
		// String memberId = (String)session.getAttribute("memberId");
		// Member member = this.memberService.retrieveMember(memberId);
		// if
		// (Integer.toString(member.getType()).equals(MemberType.ADMIN.getCode()))
		// {
		// return new ModelAndView("redirect:/admin");
		// }
		return new ModelAndView("redirect:/member/info");
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLoginForm() {
		return new ModelAndView("/loginForm");
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView showMainPage() {
		return new ModelAndView("/main/main");
	}

	// 20160703 이현승 information



	@RequestMapping(value = "/information/crocodile_info_mom", method = RequestMethod.GET)
	public ModelAndView showCrocodileInfoMomPage() {
		return new ModelAndView("/information/crocodile_info_mom");
	}
	
	@RequestMapping(value = "/information/crocodile_info_crocodile", method = RequestMethod.GET)
	public ModelAndView showCrocodileInfoPage() {
		return new ModelAndView("/information/crocodile_info_crocodile");
	}
	
	@RequestMapping(value = "/information/introduce_service", method = RequestMethod.GET)
	public ModelAndView showIntroduceServicePage() {
		return new ModelAndView("/information/introduce_service");
	}
	
	@RequestMapping(value = "/information/utilization_service", method = RequestMethod.GET)
	public ModelAndView showUtilizationServicePage() {
		return new ModelAndView("/information/utilization_service");
	}
	
	// 20160703 이현승 information
	
	@RequestMapping(value = "/notice/notice", method = RequestMethod.GET)
	public ModelAndView showNoticePage() {
		return new ModelAndView("/notice/notice");
	}
	
	@RequestMapping(value = "/notice/qna", method = RequestMethod.GET)
	public ModelAndView showQnaPage() {
		return new ModelAndView("/notice/qna");
	}
	
	// 20160703 이현승 information
	@RequestMapping(value = "/rules/privacy_statements", method = RequestMethod.GET)
	public ModelAndView showPrivacyStatementsPage() {
		return new ModelAndView("/rules/privacy_statements");
	}

	// 테스트공간
	@RequestMapping(value = "/publish/test", method = RequestMethod.GET)
	public ModelAndView testPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/publish/test");
		return mav;
	}
}
