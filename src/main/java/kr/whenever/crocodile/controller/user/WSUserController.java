package kr.whenever.crocodile.controller.user;

import java.util.HashMap;
import java.util.Map;

import kr.whenever.crocodile.domain.User;
import kr.whenever.crocodile.domain.UserSearch;
import kr.whenever.crocodile.service.UserService;
import kr.whenever.crocodile.util.JSONUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/ws/users")
public class WSUserController {
	
	@Autowired
	private UserService userService;

	/**
	 * 사용자 목록 조회.
	 * ../ws/users?pageNo=1 -> 1페이지 요청.
	 * @param search
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public UserSearch getUserListBySearch(
			UserSearch search
			) {
		UserSearch userListBySearch = userService.findUserListBySearch(search);
		return userListBySearch;
	}
	
	/**
	 * 사용자 조회.
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public User getUser(
			@PathVariable(value = "id") Long id
			) {
		User user = this.userService.findUser(id);
		return user;
	}
	
	/**
	 * 사용자 등록.
	 * @param user
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> registerUser(
			User user
			){
		Map<String, String> result = new HashMap<String, String>();
		userService.registerUser(user);
		User registerdUser  = userService.findUserByEmail(user.getUid());
		if (registerdUser != null) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		return result;
	}
	
	/**
	 * 사용자 수정.
	 * ex) 간단한 속성 예제.
	 * param = {
	 * 	pid: '1',
	 * 	nickname: 'yjkim',
	 * 	cellPhoneNo: '010-xxx-xxxx'
	 * }
	 * @param requestParam
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public Map<String, String> updateUser(
			@RequestBody Map<String, Object> requestParam
			){
		Map<String, String> result = new HashMap<String, String>();
		User updatedUser = JSONUtil.fromJson(JSONUtil.toJson(requestParam), User.class);
		User previousUser = userService.findUser(updatedUser.getPid());
		previousUser.setUpdatedUserInfo(updatedUser);

		userService.modifyUser(previousUser);
		result.put("result", "success");
		
		return result;
	}
	
	/**
	 * 사용자 삭제.
	 * ex)
	 * param = {
	 * 	pid: '1'
	 * }
	 * @param requestParam
	 * @return
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String, String> removeUser(
			@RequestBody Map<String, Object> requestParam
			){
		Map<String, String> result = new HashMap<String, String>();
		User user = JSONUtil.fromJson(JSONUtil.toJson(requestParam), User.class);
		userService.removeUser(user.getPid());
		User removedUser  = userService.findUserByEmail(user.getUid());
		if (removedUser == null) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		return result;
	}
	
	@RequestMapping(value = "/token", method = RequestMethod.POST)
	public @ResponseBody Map<String, String> getToken(
			@RequestParam("id") String email,
			@RequestParam("password") String password
			) {
		Map<String, String> identifiedUser = this.userService.identifiedUser(email, password);
		return identifiedUser;
	}
}
