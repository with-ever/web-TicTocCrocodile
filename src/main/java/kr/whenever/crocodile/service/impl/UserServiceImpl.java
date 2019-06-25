package kr.whenever.crocodile.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.whenever.crocodile.domain.User;
import kr.whenever.crocodile.domain.UserSearch;
import kr.whenever.crocodile.domain.common.UserIdentifiedType;
import kr.whenever.crocodile.repo.UserRepository;
import kr.whenever.crocodile.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	//
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void registerUser(User user) {
		//
		this.userRepository.registerUser(user);
	}
	
	@Override
	public void modifyUser(User user) {
		//
		this.userRepository.modifyUser(user);
		
	}
	
	@Override
	public void removeUser(Long pid) {
		//
		this.userRepository.removeUser(pid);
	}
	
	@Override
	public User findUser(Long uid) {
		//
		return this.userRepository.findUser(uid);
	}

	@Override
	public List<User> findUserList() {
		//
		return this.userRepository.findUserList();
	}
	
	@Override
	public Map<String, String> identifiedUser(String id, String password) {
		//
		User user = this.userRepository.findUserByEmail(id);
		Map<String, String> result = new HashMap<String, String>();
		if(user == null){
			result.put(UserIdentifiedType.NONEXISTENCE.getName(), UserIdentifiedType.NONEXISTENCE.getCode());
			return null;
		}
		if(password.equals(user.getPassword())){
			result.put(UserIdentifiedType.SUCCESS.getName(), user.getToken());
		} else {
			result.put(UserIdentifiedType.FAIL.getName(), UserIdentifiedType.FAIL.getCode());
		}
		return result;
	}
	
	@Override
	public User findUserByEmail(String uid) {
		//
		return this.userRepository.findUserByEmail(uid);
	}
	
	@Override
	public UserSearch findUserListBySearch(UserSearch search) {
		return this.userRepository.findUserListBySearch(search);
	}
}
