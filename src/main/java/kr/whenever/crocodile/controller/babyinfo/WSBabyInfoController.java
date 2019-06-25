package kr.whenever.crocodile.controller.babyinfo;

import java.util.HashMap;
import java.util.Map;

import kr.whenever.crocodile.domain.BabyInfo;
import kr.whenever.crocodile.domain.BabyInfoSearch;
import kr.whenever.crocodile.service.BabyInfoService;
import kr.whenever.crocodile.util.JSONUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api/v1/babyinfos")
public class WSBabyInfoController {
	
	@Autowired
	private BabyInfoService babyInfoService;

	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public BabyInfoSearch retrieveMemberListBySearch(
			BabyInfoSearch search
			) {
		BabyInfoSearch babyInfoListBySearch = this.babyInfoService.retrieveBabyInfoListBySearch(search);
		return babyInfoListBySearch;
	}
	
	
	@RequestMapping(value = "/{babyId}", method = RequestMethod.GET)
	@ResponseBody
	public BabyInfo retrieveBabyInfo(
			@PathVariable(value = "babyId") int babyId
			) {
		BabyInfo babyInfo = this.babyInfoService.retrieveBabyInfo(babyId);
		return babyInfo;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> registerBabyInfo(
			@RequestBody Map<String, Object> requestParam
			){
		Map<String, String> result = new HashMap<String, String>();
		BabyInfo babyInfo = JSONUtil.fromJson(JSONUtil.toJson(requestParam), BabyInfo.class);
		babyInfo.setTimeInfo();
		int babyId = this.babyInfoService.registerBabyInfo(babyInfo);
		result.put("result", Integer.toString(babyId));
		return result;
	}
	
	@RequestMapping(value = "/{babyId}", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String, String> modifyBabyInfo(
			@PathVariable(value = "babyId") int babyId,
			@RequestBody Map<String, Object> requestParam
			){
		
		Map<String, String> result = new HashMap<String, String>();
		BabyInfo updatedBabyInfo = JSONUtil.fromJson(JSONUtil.toJson(requestParam), BabyInfo.class);
		updatedBabyInfo.setBabyId(babyId);
		this.babyInfoService.modifyBabyInfo(updatedBabyInfo);
		result.put("result", "success");
		
		return result;
	}
	
	@RequestMapping(value = "/{babyId}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String, String> removeBabyInfo(
			@PathVariable(value = "babyId") int babyId
			){
		
		Map<String, String> result = new HashMap<String, String>();
		this.babyInfoService.removeBabyInfo(babyId);
		result.put("result", "success");
		return result;
	}
	
}
