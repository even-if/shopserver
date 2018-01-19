package cn.edu.neu.mapper;

import java.util.List;

import cn.edu.neu.core.common.Page;
import cn.edu.neu.model.User;

public interface UserMapper {	
	
	User existsUser(User user);
	int addUser(User user);
	int existsUserName(User user);
	User existsAdmin(User user);
	User getPersonalInfo(int loginUserId);
	void updatePersonalInfo(User user);
	void updatePersonalPassword(User user);

}
