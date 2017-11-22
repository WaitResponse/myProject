package com.gem.xianzhi.dao;

import java.util.List;

import com.gem.xianzhi.dao.base.IBaseDAO;
import com.gem.xianzhi.pojo.Discuss;

public interface DiscussDAO extends IBaseDAO<Discuss> {
	
	//1.根据用户ID加载用户发布的评论
	List<Discuss>getDiscuss(int userId);
}
