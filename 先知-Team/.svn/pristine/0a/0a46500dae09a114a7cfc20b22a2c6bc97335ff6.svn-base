package com.gem.xianzhi.dao.impl;

import java.util.List;
import java.util.Set;

import com.gem.xianzhi.dao.ReplyDAO;
import com.gem.xianzhi.dao.base.impl.BaseDAO;
import com.gem.xianzhi.pojo.Discuss;
import com.gem.xianzhi.pojo.Reply;

public class ReplyDAOImpl  extends BaseDAO<Reply> implements ReplyDAO{

	@Override
	public List<Reply> getReplyList(int userId) {
		String hql = "from Reply r where r.author.id=? order by r.date asc";
		return (List<Reply>)getHibernateTemplate().find(hql, userId);
	}
}
