package com.gem.xianzhi.dao;

import java.util.List;
import java.util.Set;

import com.gem.xianzhi.dao.base.IBaseDAO;
import com.gem.xianzhi.pojo.News;

public interface NewsDAO extends IBaseDAO<News> {
	
	//4.根据关键字获取新闻(desc)
	List<News>getNewsList(String keyword , int pageSize ,int classifyId, int pageNum);
	
	//5.获取新闻总页数
	int getNewsCount(String keyword , int pageSize,int classifyId);
	
	//6...(asc)
	List<News>getNewsListAsc(String keyword , int pageSize ,int classifyId, int pageNum);

	
	//7.前台获取新闻列表(每次加载50条,按最近时间排序)
	List<News>getNewsList();
	
	//8.热词搜索
	List<News>getHotNewsList();
	
	
	//前台根据关键字查询
	List<News> getNewsList(String keyword);
	
	List<News>getfabuNewsList(int userId);
}
