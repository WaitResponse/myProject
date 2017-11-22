package com.gem.xianzhi.Biz;

import java.util.List;

import com.gem.xianzhi.pojo.Reply;

public interface ReplyBiz {
	
	//1.根据用户ID加载用户发布的回复
	List<Reply>getReplyList(int userId);
}
