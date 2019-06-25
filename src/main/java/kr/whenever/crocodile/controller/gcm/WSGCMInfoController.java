package kr.whenever.crocodile.controller.gcm;

import java.util.HashMap;
import java.util.Map;

import kr.whenever.crocodile.domain.GCMInfo;
import kr.whenever.crocodile.service.GCMInfoService;
import kr.whenever.crocodile.util.JSONUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api/v1/gcm")
public class WSGCMInfoController {

	@Autowired
	private GCMInfoService gcmInfoService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> registerGCMInfo(
			@RequestBody Map<String, Object> requestParam
			){
		Map<String, String> result = new HashMap<String, String>();
		GCMInfo gcmInfo = JSONUtil.fromJson(JSONUtil.toJson(requestParam), GCMInfo.class);
		int index = this.gcmInfoService.registerGCMInfo(gcmInfo);
		result.put("result", Integer.toString(index));
		return result;
	}
	
	@RequestMapping(value = "/{memberId}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String, String> removeGCMInfo(
			@PathVariable(value = "memberId") String memberId
			){
		Map<String, String> result = new HashMap<String, String>();
		this.gcmInfoService.removeGCMInfoByMemberId(Integer.parseInt(memberId));
		result.put("result", "success");
		return result;
	}	

}
