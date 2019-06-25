package kr.whenever.crocodile.controller.user;

import java.util.List;

import kr.whenever.crocodile.domain.User;
import kr.whenever.crocodile.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	/**
	 * 사용자 목록
	 * @return
	 */
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public ModelAndView findUserList() {
		//
		List<User> users = this.userService.findUserList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/userList");
		mav.addObject("users", users);
		return mav;
	}
	
	/**
	 * 사용자 등록 화면
	 * @return
	 */
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView registerUserForm() {
		//
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/userRegist");
		return mav;
	}
	
	/**
	 * 사용자 등록
	 * @param user
	 * @return
	 */
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
	
	/**
	 * 사용자 수정 화면
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{pid}/modify", method = RequestMethod.GET)
	public ModelAndView modifyUserForm(
			@PathVariable(value = "pid") Long pid
			) {
		//
		User user = this.userService.findUser(pid);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/userModify");
		mav.addObject("user", user);
		return mav;
	}
	
	/**
	 * 사용자 수정
	 * @param id
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/{pid}", method = RequestMethod.POST)
	public ModelAndView modifyUser(
			@PathVariable(value = "pid") Long pid,
			User user
			) {
		//
		this.userService.modifyUser(user);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/user/list");
		return mav;
	}
	
	/**
	 * 사용자 삭제
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{pid}/remove", method = RequestMethod.POST)
	public ModelAndView removeUser(
			@PathVariable("pid") Long pid
			) {
		//
		this.userService.removeUser(pid);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/user/list");
		return mav ;
	}
	
	/**
	 * 사용자 조회
	 * @return
	 */
	@RequestMapping(value = "/{pid}", method = RequestMethod.GET)
	public ModelAndView findUser(
			@PathVariable("pid") Long pid
			) {
		//
		User user = this.userService.findUser(pid);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/userView");
		mav.addObject("user", user);
		return mav;
	}
}
