package com.gem.qqzone.dao.impl;

import java.util.Set;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.gem.qqzone.dao.TopicDAO;
import com.gem.qqzone.pojo.Topic;
import com.gem.qqzone.pojo.User;

public class TopicDAOImpl extends HibernateDaoSupport implements TopicDAO {
	public Set<Topic> getTopics(int userId) {
		Set<Topic> topics = getHibernateTemplate().load(User.class, userId).getTopics();
		return topics;
	}

	public Topic getTopic(int id) {
		Topic topic = getHibernateTemplate().load(Topic.class, id);
		return topic ;
	}

	@Override
	public void addTopic(Topic topic) {
		getHibernateTemplate().save(topic);
		
	}
	public void delTopic(int id){
		//������hql���ȥɾ������HQLɾ���м����Ĺ�ϵ
		//ɾ��֮ǰ���ҵ�
		getHibernateTemplate().delete(getTopic(id));
	}
	
}
