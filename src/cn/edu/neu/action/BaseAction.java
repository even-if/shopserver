package cn.edu.neu.action;

import javax.annotation.Resource;

import cn.edu.neu.core.Constants;
import cn.edu.neu.core.common.CommonBaseAction;
import cn.edu.neu.model.User;


public class BaseAction extends CommonBaseAction{
	
	
	/* 获取登录用户ID */
	public int getLoginUserId() {
		User user = getLoginUser();
		if (user != null) {
			//return new Long(((BigDecimal) user.get("userid")).longValue());
			return user.getUserId();
		}
		return 0;
	}

	/* 获取登录用户名 */
	public String getLoginUserName() {
		User user = getLoginUser();
		if (user != null) {
			return (String) user.getUserName();
		}
		return null;
	}

	/* 获取登录用户对象 */
	public User getLoginUser() {
		return (User) getSession().getAttribute(Constants.LOGIN_USER);
	}
}
