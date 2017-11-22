package com.gem.xianzhi.Biz.impl;

import com.gem.xianzhi.Biz.UserDetailBiz;
import com.gem.xianzhi.dao.UserDetailDAO;
import com.gem.xianzhi.pojo.UserDetail;

public class UserDetailBizImpl implements UserDetailBiz {
	private UserDetailDAO userDetailDAO;
	
	@Override
	public int add(UserDetail userDetail) {
		return (int)userDetailDAO.add(userDetail);
	}

	public UserDetailDAO getUserDetailDAO() {
		return userDetailDAO;
	}

	public void setUserDetailDAO(UserDetailDAO userDetailDAO) {
		this.userDetailDAO = userDetailDAO;
	}

	@Override
	public void update(UserDetail userDetail) {
		userDetailDAO.update(userDetail);
	}

	
}
