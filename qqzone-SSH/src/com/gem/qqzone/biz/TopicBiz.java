package com.gem.qqzone.biz;

import java.util.Set;

import com.gem.qqzone.pojo.Topic;
import com.gem.qqzone.pojo.User;

public interface TopicBiz {
	//��ȡ�ض��û���������־
	Set<Topic> getTopics(User user);
	
	//�������־
	void addToic(Topic topic);
	//ɾ����־(��ɾ�����лظ�)
	void delTopic(Topic topic);
	//��ȡ�ض���־��Ϣ
	Topic getTopic(int id);
}
