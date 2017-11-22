package com.gem.qqzone.biz.impl;

import java.util.Set;

import com.gem.qqzone.biz.TopicBiz;
import com.gem.qqzone.dao.ReplyDAO;
import com.gem.qqzone.dao.TopicDAO;
import com.gem.qqzone.pojo.Reply;
import com.gem.qqzone.pojo.Topic;
import com.gem.qqzone.pojo.User;

public class TopicBizImpl implements TopicBiz {

	private TopicDAO topicDAO = null;
	private ReplyDAO replyDAO = null;
	
	public Set<Topic> getTopics(User user) {
		return topicDAO.getTopics(user.getId());
	}

	public Topic getTopic(int id) {
		//1.��ȡ��־���������
		Topic topic = topicDAO.getTopic(id);
		
		//2.��ȡ��־�����лظ�(�������ظ������˻ظ�������Ҫͬʱ�����˻ظ�����)
		Set<Reply> replies = replyDAO.getReplies(topic.getId());
		
		topic.setReplies(replies);
		
		return topic;
	}

	public TopicDAO getTopicDAO() {
		return topicDAO;
	}

	public void setTopicDAO(TopicDAO topicDAO) {
		this.topicDAO = topicDAO;
	}

	public ReplyDAO getReplyDAO() {
		return replyDAO;
	}

	public void setReplyDAO(ReplyDAO replyDAO) {
		this.replyDAO = replyDAO;
	}

	@Override
	public void addToic(Topic topic) {
		topicDAO.addTopic(topic);		
	}

	@Override
	public void delTopic(Topic topic) {
		topicDAO.delTopic(topic.getId());	
	}

}
