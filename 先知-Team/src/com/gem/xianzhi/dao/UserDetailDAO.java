package com.gem.xianzhi.dao;

import com.gem.xianzhi.dao.base.IBaseDAO;
import com.gem.xianzhi.pojo.UserDetail;

public interface UserDetailDAO extends IBaseDAO<UserDetail> {

	UserDetail getUserDetail(int userId);
}
