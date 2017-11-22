package com.gem.xianzhi.dao.impl;

import java.util.List;
import java.util.Set;

import com.gem.xianzhi.dao.DiscussDAO;
import com.gem.xianzhi.dao.base.impl.BaseDAO;
import com.gem.xianzhi.pojo.Discuss;
import com.gem.xianzhi.pojo.News;

public class DiscussDAOImpl extends BaseDAO<Discuss> implements DiscussDAO {

	@Override
	public List<Discuss> getDiscuss(int userId) {
		String hql = "from Discuss d where d.author.id=? order by d.date asc";
	
		return (List<Discuss>)getHibernateTemplate().find(hql, userId);
	}
}
