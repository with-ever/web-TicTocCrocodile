package kr.whenever.crocodile.controller.member;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.whenever.crocodile.domain.CrocAvailableRegion;
import kr.whenever.crocodile.domain.CrocAvailableService;
import kr.whenever.crocodile.domain.CrocAvailableTime;
import kr.whenever.crocodile.domain.Member;
import kr.whenever.crocodile.domain.common.member.MemberType;
import kr.whenever.crocodile.service.MemberService;
import kr.whenever.crocodile.util.AWSS3Util;
import kr.whenever.crocodile.util.FileUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	/**
	 * 사용자 조회
	 * @return
	 */
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public ModelAndView findMember(
			HttpSession session
			) {
		//
		Member member = this.memberService.retrieveMember((String)session.getAttribute("memberId"));
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/showMember");
		mav.addObject("member", member);
		return mav;
	}
	
	/**
	 * 사용자 등록 화면
	 * @return
	 */
	/*
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView registerMemberForm() {
		//
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/registerMember");
		return mav;
	}
	*/
	
	/**
	 * 사용자 등록
	 * @param member
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 * @throws FileNotFoundException 
	 */
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView registerMember(
			@ModelAttribute Member member,
			HttpServletRequest request
			) throws FileNotFoundException, IllegalStateException, IOException {
		parseCrocInfo(member, request);
		
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		String imageUrl = uploadImage(this.memberService.retrieveLastMemberId(), multipartHttpServletRequest.getFile("image"));
		member.setType(Integer.parseInt(MemberType.CROCODILE.getCode()));
		member.getCrocMemberInfo().setImageUrl(imageUrl);
		this.memberService.registerMember(member);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/member/info");
		return mav;
	}
	
	private void parseCrocInfo(Member member, HttpServletRequest request) {
		List<CrocAvailableService> crocAvailableServices = new ArrayList<CrocAvailableService>();
		List<CrocAvailableRegion> crocAvailableRegions = new ArrayList<CrocAvailableRegion>();
		List<CrocAvailableTime> crocAvailableTimes = new ArrayList<CrocAvailableTime>();
		
		Map parameterMap = request.getParameterMap();
		String[] serviceIds = (String[]) parameterMap.get("serviceId");
		String[] regionIds = (String[]) parameterMap.get("regionId");
		String[] days = (String[]) parameterMap.get("day");
		String[] startTime = (String[]) parameterMap.get("startTime");
		String[] endTime = (String[]) parameterMap.get("endTime");
		
		if (serviceIds != null && serviceIds.length > 0) {
			for (String serviceId : serviceIds) {
				CrocAvailableService crocAvailableService = new CrocAvailableService();
				crocAvailableService.setServiceId(Integer.parseInt(serviceId));
				crocAvailableServices.add(crocAvailableService);
			}
			member.getCrocMemberInfo().setCrocAvailableServices(crocAvailableServices);
		}
		
		if (regionIds != null && regionIds.length > 0) {
			for (String regionId : regionIds) {
				CrocAvailableRegion crocAvailableRegion = new CrocAvailableRegion();
				crocAvailableRegion.setRegionId(Integer.parseInt(regionId));
				crocAvailableRegions.add(crocAvailableRegion);
			}
			member.getCrocMemberInfo().setCrocAvailableRegions(crocAvailableRegions);
		}
		
		if (days != null && days.length > 0) {
			for (int index = 0; index < days.length; index++) {
				CrocAvailableTime crocAvailableTime = new CrocAvailableTime();
				crocAvailableTime.setDay(Integer.parseInt(days[index]));
				crocAvailableTime.setStartTime(Integer.parseInt(startTime[index]));
				crocAvailableTime.setEndTime(Integer.parseInt(endTime[index]));
				crocAvailableTimes.add(crocAvailableTime);
			}
			member.getCrocMemberInfo().setCrocAvailableTimes(crocAvailableTimes);
		}
	}
	
	private String uploadImage(int memberId, MultipartFile multipartFile) throws FileNotFoundException, IllegalStateException, IOException {
		if (multipartFile == null || multipartFile.getSize() == 0) return null;
		AWSS3Util s3Util = new AWSS3Util();
		String bucketName = s3Util.createBuckectName(MemberType.CROCODILE.getCode());
		String fileName = s3Util.createFileName(String.valueOf(memberId), multipartFile.getOriginalFilename());
		s3Util.fileUpload(bucketName, fileName, FileUtil.convertMultipartFileToFile(multipartFile));
		String url = s3Util.getFileURL(bucketName, fileName);
		return url.split("\\?")[0];
	}

	/**
	 * 사용자 수정 화면
	 * @param id
	 * @param member
	 * @return
	 */
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public ModelAndView modifyMemberForm(
			@PathVariable(value = "id") String id
			) {
		Member member = this.memberService.retrieveMember(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("member", member);
		mav.setViewName("/member/modifyMember");
		return mav;
	}
	
	/**
	 * 사용자 수정
	 * @param id
	 * @param member
	 * @return
	 */
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
	public ModelAndView modifyMember(
			@PathVariable(value = "id") String id,
			Member member,
			HttpServletRequest request
			) {
		parseCrocInfo(member, request);
		this.memberService.modifyMember(member);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/member/info");
		return mav;
	}
	
	
	/**
	 * 사용자 삭제
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}/remove", method = RequestMethod.POST)
	public ModelAndView removeMember(
			@PathVariable("id") String id
			) {
		//
		this.memberService.removeMember(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/member");
		return mav ;
	}
	
}