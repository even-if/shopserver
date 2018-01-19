package cn.edu.neu.service;

import cn.edu.neu.core.common.Page;

import cn.edu.neu.model.User;


public interface UserService {
	User existsUser(User user);
	boolean addUser(User user);
	boolean existsUserName(String userName);
	User existsAdmin(User user);
	User getPersonalInfo(int loginUserId);
	void updatePersonalInfo(User user);
	void updatePersonalPassword(User user);
}
