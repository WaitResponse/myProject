package com.gem.xianzhi.dao.impl;

import java.util.List;
import java.util.Set;

import com.gem.xianzhi.dao.NewsDAO;
import com.gem.xianzhi.dao.base.impl.BaseDAO;
import com.gem.xianzhi.pojo.Classify;
import com.gem.xianzhi.pojo.News;
import com.gem.xianzhi.pojo.User;
import com.gem.xianzhi.util.StringUtil;

import ognl.SetPropertyAccessor;

public class NewsDAOImpl extends BaseDAO<News> implements NewsDAO {

	@Override
	public List<News> getNewsList(String keyword, int pageSize, int classifyId, int pageNum) {
		if(classifyId==0){//分类为全部		
			String hql ="from News n where n.title like ? order by n.date desc";	
			return getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql)
													.setParameter(0, "%"+keyword+"%")
													.setFirstResult((pageNum-1)*pageSize )
													.setMaxResults(pageSize).list();
		}else{
			String hql = "from News n where n.classify.id=? and n.title like ? order by n.date desc";
			return getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql)
																	.setParameter(0, classifyId)
																	.setParameter(1, "%"+keyword+"%")
																	.setFirstResult((pageNum-1)*pageSize )
																	.setMaxResults(pageSize).list();
		}
		
	}

	@Override
	public int getNewsCount(String keyword, int pageSize, int classifyId) {
		if(classifyId==0){
			String hql="select count(*) from News n where n.title like ? ";
			int count = ((Long)getHibernateTemplate().find(hql,"%"+keyword+"%").get(0)).intValue();
			return (count+pageSize-1)/pageSize;
		}else{
			String hql = "select count(*) from News n where n.title like ? and n.classify.id =? ";
			int count = ((Long)getHibernateTemplate().find(hql,"%"+keyword+"%",classifyId).get(0)).intValue();
			return (count+pageSize-1)/pageSize;
		}
	}

	@Override
	public List<News> getNewsListAsc(String keyword, int pageSize, int classifyId, int pageNum) {
		if(classifyId==0){//分类为全部
			String hql ="from News n where n.title like ? order by n.date asc";
			return getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql)
													.setParameter(0, "%"+keyword+"%")
													.setFirstResult((pageNum-1)*pageSize )
													.setMaxResults(pageSize).list();
		}else{
			String hql = "from News n where n.classify.id=? and n.title like ? order by n.date asc";
			return getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql)
																	.setParameter(0, classifyId)
																	.setParameter(1, "%"+keyword+"%")
																	.setFirstResult((pageNum-1)*pageSize )
																	.setMaxResults(pageSize).list();
		}
	}

	@Override
	public List<News> getNewsList() {
		String hql = "from News n order by n.date desc";
		return getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql)
															.setFirstResult(0)
															.setMaxResults(50).list();
	}

	@Override
	public List<News> getHotNewsList() {
		String hql="from News n order by n.visitCount desc";//根据访问量降序排序
		return getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql)
																			.setFirstResult(0)
																			.setMaxResults(6)
																			.list();

	}

	@Override
	public List<News> getNewsList(String keyword) {
		if (StringUtil.isEmpty(keyword)) {
			keyword = "";
		}
		String hql = "from News n where n.title like ?";
		return getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql)
				.setParameter(0, "%" + keyword + "%").list();
	}

	@Override
	public List<News> getfabuNewsList(int userId) {
		String hql = "from News n where n.author.id=? order by n.visitCount desc";
		return getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql)
																	.setParameter(0, userId)
																	.setFirstResult(0)
																	.setMaxResults(6)
																	.list();
	}



}
