package kr.whenever.crocodile.repo;

import java.util.List;

import kr.whenever.crocodile.domain.User;
import kr.whenever.crocodile.domain.UserSearch;
import kr.whenever.crocodile.repo.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository{

	@Autowired
	private UserMapper userMapper;

	public void registerUser(User user) {
		//
		this.userMapper.insertUser(user);
	}

	public void modifyUser(User user) {
		//
		this.userMapper.updateUser(user);
	}
	
	public void removeUser(Long pid) {
		//
		this.userMapper.deleteUser(pid);
	}
	
	public User findUser(Long pid) {
		//
		return this.userMapper.selectUser(pid);
	}

	public List<User> findUserList() {
		//
		return this.userMapper.selectUserList();
	}
	
	public User findUserByEmail(String uid) {
		//
		return this.userMapper.selectUserByEmail(uid);
	}

	public UserSearch findUserListBySearch(UserSearch search) {
		//
		List<User> users = this.userMapper.selectUserListBySearch(search);
		search.setResults(users);
		
		if (users.size() != 0) {
			int totalCount = this.userMapper.selectUserListTotalCount(search);
			search.setTotalCount(totalCount);
		}
		
		return search;
	}
	
}
