package kr.whenever.crocodile.controller.admin;

import javax.servlet.http.HttpSession;

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
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView index(
			HttpSession session
			){
		return new ModelAndView("redirect:/admin/croc");
	}
	
	/**
	 * 관리자 로그인 관련.
	 */
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView showLoginForm() {
		return new ModelAndView("/admin/loginForm");
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public ModelAndView showLogoutForm() {
		return new ModelAndView("/admin/logoutForm");
	}
	
	@RequestMapping(value="/loginFail", method=RequestMethod.GET)
	public ModelAndView showLoginFail() {
		return new ModelAndView("/admin/loginFail");
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
