package com.gem.xianzhi.Biz.impl;

import java.util.List;

import com.gem.xianzhi.Biz.ReplyBiz;
import com.gem.xianzhi.dao.ReplyDAO;
import com.gem.xianzhi.pojo.Reply;

public class ReplyBizImpl implements ReplyBiz {
	private ReplyDAO replyDAO;
	
	@Override
	public List<Reply> getReplyList(int userId) {
		return replyDAO.getReplyList(userId);
	}

	public ReplyDAO getReplyDAO() {
		return replyDAO;
	}

	public void setReplyDAO(ReplyDAO replyDAO) {
		this.replyDAO = replyDAO;
	}

	
}
