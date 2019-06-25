package kr.whenever.crocodile.controller.matching;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import kr.whenever.crocodile.domain.Matching;
import kr.whenever.crocodile.domain.MatchingSearch;
import kr.whenever.crocodile.service.MatchingService;
import kr.whenever.crocodile.util.JSONUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api/v1/matchings")
public class WSMatchingController {
	
	@Autowired
	private MatchingService matchingService;

	/**
	 * 매칭 목록 조회.
	 * ../ws/matchings?pageNo=1 -> 1페이지 요청.
	 * @param search
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public MatchingSearch getMatchingListBySearch(
			MatchingSearch search
			) {
		MatchingSearch matchingListBySearch = matchingService.retrieveMatchingListBySearch(search);
		return matchingListBySearch;
	}
	
	/**
	 * 매칭 조회.
	 * @param matchId
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Matching getMatching(
			@PathVariable(value = "id") int matchId
			) {
		Matching matching = this.matchingService.retrieveMatching(matchId);
		return matching;
	}
	
	/**
	 * 매칭 등록.
	 * @param matching
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> registerMatching(
			@RequestBody Map<String, Object> requestParam
			) throws IOException{
		Map<String, String> result = new HashMap<String, String>();
		Matching matching = JSONUtil.fromJson(JSONUtil.toJson(requestParam), Matching.class);
		int matchId = this.matchingService.registerMatching(matching);
		result.put("result", Integer.toString(matchId));
		return result;
	}
	
	/**
	 * 매칭 수정
	 * @param requestParam
	 * @return
	 */
	@RequestMapping(value = "/{matchId}", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String, String> updateMatching(
			@PathVariable(value = "matchId") int matchId,
			@RequestBody Map<String, Object> requestParam
			){
		Map<String, String> result = new HashMap<String, String>();
		Matching updatedMatching = JSONUtil.fromJson(JSONUtil.toJson(requestParam), Matching.class);
		updatedMatching.setMatchId(matchId);
		this.matchingService.modifyMatching(updatedMatching);
		result.put("result", "success");
		
		return result;
	}
	
	/**
	 * 매칭 상태 수정
	 * @param requestParam
	 * @return
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	@RequestMapping(value = "/{matchId}/status", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String, String> modifyMatchingStatus(
			@PathVariable(value = "matchId") int matchId,
			@RequestBody Map<String, Object> requestParam
			) throws NumberFormatException, IOException{
		Map<String, String> result = new HashMap<String, String>();
		String contractId = (String) requestParam.get("contractId");
		String status = (String) requestParam.get("status");
		this.matchingService.modifyMatchingStatus(matchId, Integer.parseInt(status), Integer.parseInt(contractId));
		result.put("result", "success");
		
		return result;
	}
	
	/**
	 * 매칭 삭제.
	 * @param requestParam
	 * @return
	 */
	@RequestMapping(value ="/{matchId}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String, String> removeMatching(
			@PathVariable(value = "matchId") int matchId
			){
		Map<String, String> result = new HashMap<String, String>();
		matchingService.removeMatching(matchId);
		result.put("result", "success");
		return result;
	}
}
