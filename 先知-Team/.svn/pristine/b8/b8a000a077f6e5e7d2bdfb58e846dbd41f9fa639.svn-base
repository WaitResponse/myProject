package com.gem.xianzhi.dao.impl;

import java.util.List;

import com.gem.xianzhi.dao.VideoDAO;
import com.gem.xianzhi.dao.base.impl.BaseDAO;
import com.gem.xianzhi.pojo.Video;
import com.gem.xianzhi.util.StringUtil;

public class VideoDAOImpl extends BaseDAO<Video> implements VideoDAO {

	@Override
	public List<Video> getHotVideoList() {
		String hql = "from Video v order by v.clickCount desc";
		return getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql)
																			.setFirstResult(0)
																			.setMaxResults(6)
																			.list();
	}

	@Override
	public List<Video> getVedioList(String keyword) {
		if(StringUtil.isEmpty(keyword)){
			keyword = "" ;
		}
		String hql = "from Video v where v.title like ?" ;
		return getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createQuery(hql).setParameter(0, "%"+keyword+"%").list();
	}



}
