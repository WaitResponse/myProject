package com.gem.xianzhi.dao;

import java.util.List;

import com.gem.xianzhi.dao.base.IBaseDAO;
import com.gem.xianzhi.pojo.Reply;

public interface ReplyDAO extends IBaseDAO<Reply> {
	
	//1.根据用户Id加载用户发布的回复
	List<Reply>getReplyList(int userId);
	
}
