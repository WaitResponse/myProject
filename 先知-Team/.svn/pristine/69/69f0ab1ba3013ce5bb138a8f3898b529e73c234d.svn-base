package com.gem.xianzhi.Biz;

import java.util.List;

import com.gem.xianzhi.pojo.News;

public interface NewsBiz {
	
	//1.根据关键字，每页记录，当前页数获取新闻列表(desc)
	List<News>getNewsList(String keyword, int pageSize,int classifyId, int pageNum);
	
	//2.根据关键字，每页记录，当前页数获取新闻列表(asc)
	List<News>getNewsListAsc(String keyword, int pageSize,int classifyId, int pageNum);
	
	List<News>getNewsList(String keyword, int pageSize,int pageNum);
	
	int getNewsCount(String keyword , int pageSize);
	
	//3.根据关键字，每页记录获取总页数
	int getNewsCount(String keyword , int pageSize ,int classifyId);
		
	//4.根据新闻id获取新闻
	News getNews(int newsId);
	
	//5.根据新闻Id删除新闻
	void delNews(int newsId);
	
	//6.前台首页获取新闻列表
	List<News>getNewsList();
	//6.发布文章
	void addNews(News news);
	//7.更新新闻
	void update(News news);
	
	//8.获取热门新闻列表(根据访问量找到6条数据,b)
	List<News>hotNewsList();
	
	//9.前台搜索
	List<News> getNewsList(String keyword);
	
	//10.根据用户Id获取用户发布的新闻
	List<News>getfabuNewsList(int userId);
}
