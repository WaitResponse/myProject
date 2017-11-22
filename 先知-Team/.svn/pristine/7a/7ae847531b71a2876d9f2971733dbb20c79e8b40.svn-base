package com.gem.xianzhi.Biz.impl;

import java.util.List;
import java.util.Set;

import com.gem.xianzhi.Biz.UserBiz;
import com.gem.xianzhi.dao.NewsDAO;
import com.gem.xianzhi.dao.UserDAO;
import com.gem.xianzhi.pojo.News;
import com.gem.xianzhi.pojo.User;
import com.gem.xianzhi.util.StringUtil;

public class UserBizImpl implements UserBiz{
	
	private UserDAO userDAO=null;
	private NewsDAO newsDAO=null;
	@Override
	public User login(String loginId, String pwd) {
		User user=userDAO.login(loginId, pwd);
		return user;
	}

	@Override
	public User getUser(int id) {
		User user = userDAO.get(id);
		return user;
	}

	@Override
	public void update(User user) {
		userDAO.updateUser(user);
	}

	
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public List<User> getUserList(String keyword, int pageSize, int pageNum) {
		return 	userDAO.getUserList(keyword, pageSize, pageNum);
	}
	//»ñÈ¡Ò³Êý
	@Override
	public int getUserCount(String keyword, int pageSize) {
		int count=StringUtil.isEmpty(keyword)?userDAO.getUserCount() : userDAO.getUserCount(keyword);
		return (count+pageSize-1)/pageSize;
	}

	@Override
	public List<User> getUserByType(String keyword,int pageSize, int pageNum) {
		return userDAO.getUserByType(keyword,pageSize,pageNum);
	}

	@Override
	public int getUserCountByType(String keyword, int pageSize) {
		int count=StringUtil.isEmpty(keyword)?userDAO.getUserCount() : userDAO.getUserCountByType(keyword);
		return (count+pageSize-1)/pageSize;
	}

	@Override
	public User getUserByLN(String loginId, String nickName) {
		return userDAO.getUserByLN(loginId,nickName);
	}

	@Override
	public int add(User user) {
		return (int) userDAO.add(user);
	}

	@Override
	public User login(String loginId) {
		return userDAO.login(loginId);
	}

	@Override
	public List<User> getUserList(String keyword) {	
		return userDAO.getUserList(keyword);
	}

	@Override
	public void addCollectNews(User user) {
		userDAO.update(user);
		
	}

	@Override
	public void removeCollectNews(int newsId, int userId) {
		User user = userDAO.get(userId);
		News news = newsDAO.get(newsId);
		Set<News> CollectNews = user.getCollectNews();
		CollectNews.remove(news);
		
	}

	@Override
	public void saveOrUpdate(User user) {
		userDAO.saveOrUpdate(user);
		
	}



}
