package com.gem.xianzhi.dao;

import java.util.List;

import com.gem.xianzhi.dao.base.IBaseDAO;
import com.gem.xianzhi.pojo.Reply;

public interface ReplyDAO extends IBaseDAO<Reply> {
	
	//1.�����û�Id�����û������Ļظ�
	List<Reply>getReplyList(int userId);
	
}
