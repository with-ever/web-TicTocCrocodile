package kr.whenever.crocodile.controller.admin;

import java.io.IOException;


import kr.whenever.crocodile.domain.MatchingSearch;
import kr.whenever.crocodile.service.MatchingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin/matching")
public class AdminMatchingController {
	
	@Autowired
	private MatchingService matchingService;
	
	/**
	 * 매칭 목록 조회.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView showMatchingList(
			MatchingSearch search
			) {
		ModelAndView mav = new ModelAndView();
		MatchingSearch matchingListBySearch = this.matchingService.retrieveMatchingListBySearch(search);
		mav.addObject("searchModel", matchingListBySearch);
		mav.setViewName("/admin/showMatchingList");
		return mav;
	}
	
	/**
	 * 매칭 상태 변경.
	 * @throws IOException 
	 */
	@RequestMapping(value="/{matchId}", method = RequestMethod.POST)
	public ModelAndView changeMatchingStatus(
			@PathVariable(value = "matchId") int matchId,
			int status,
			int contractId
			) throws IOException {
		ModelAndView mav = new ModelAndView();
		this.matchingService.modifyMatchingStatus(matchId, status, contractId);
		mav.setViewName("redirect:/admin/matching");
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
