package com.gem.xianzhi.actions;

import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;

import com.gem.xianzhi.Biz.ClassifyBiz;
import com.gem.xianzhi.Biz.DiscussBiz;
import com.gem.xianzhi.Biz.NewsBiz;
import com.gem.xianzhi.Biz.UserBiz;
import com.gem.xianzhi.Biz.VideoBiz;
import com.gem.xianzhi.pojo.Classify;
import com.gem.xianzhi.pojo.Discuss;
import com.gem.xianzhi.pojo.News;
import com.gem.xianzhi.pojo.User;
import com.gem.xianzhi.pojo.Video;
import com.opensymphony.xwork2.ActionContext;

public class NewsAction {   
	private NewsBiz newsBiz;
	private UserBiz userBiz;
	private VideoBiz videoBiz;
	private Video video;
	private ClassifyBiz classifyBiz;
	private DiscussBiz discussBiz;
	private int currPage;
	private String keyword;
	private int newsId;
	private News news;
	private int classifyId;
	private String timeSort;//时间排序方式
	
	
	public String getNewsList(){
		if(currPage<=0){
			currPage = 1;
		}
		if(keyword==null){
			keyword="";
		}
		List<Classify> classifyList = classifyBiz.getClassifyList();
		ActionContext.getContext().getSession().put("classifyList", classifyList);
		int pageSize = 10;		
		int pageCount = newsBiz.getNewsCount(keyword,pageSize,classifyId);	
		ActionContext.getContext().getSession().put("pageCount", pageCount);		
		if(currPage>pageCount){
			currPage--;
		}
		if(timeSort==null||timeSort.equals("最新时间排序")){
			List<News>newsList = newsBiz.getNewsList(keyword, pageSize, classifyId, currPage);
			ActionContext.getContext().getSession().put("newsList1", newsList);
		}else{
			List<News>newsList = newsBiz.getNewsListAsc(keyword, pageSize, classifyId, currPage);
			ActionContext.getContext().getSession().put("newsList1", newsList);		
		}
		ActionContext.getContext().getSession().put("currPage", currPage);	
			return "loadAllSuccess";
	}
	public String search(){
		List<News> newsList =newsBiz.getNewsList(keyword);
		List<User> userList = userBiz.getUserList(keyword);
		List<Video> videoList=videoBiz.getVideoList(keyword);
		for(News news: newsList){
			news.getAuthor().getNickName();
		}
		ActionContext.getContext().getSession().put("newsList2",newsList);
		ActionContext.getContext().getSession().put("userList2",userList);
		ActionContext.getContext().getSession().put("videoList", videoList);
		return "Searchsuccess";
	}
	public String updateNews(){
		News news1 = newsBiz.getNews(news.getId());
		news1.setAudit("已审核");
		newsBiz.update(news1);
		return "updateNewsSuccess";
	}

	public String delNews(){
		newsBiz.delNews(news.getId());
		return "delSuccess";
	}

	
	public NewsBiz getNewsBiz() {
		return newsBiz;
	}

	public void setNewsBiz(NewsBiz newsBiz) {
		this.newsBiz = newsBiz;
	}

	public UserBiz getUserBiz() {
		return userBiz;
	}

	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}

	public ClassifyBiz getClassifyBiz() {
		return classifyBiz;
	}

	public void setClassifyBiz(ClassifyBiz classifyBiz) {
		this.classifyBiz = classifyBiz;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public int getClassifyId() {
		return classifyId;
	}

	public void setClassifyId(int classifyId) {
		this.classifyId = classifyId;
	}

	public String getTimeSort() {
		return timeSort;
	}

	public void setTimeSort(String timeSort) {
		this.timeSort = timeSort;
	}

	public DiscussBiz getDiscussBiz() {
		return discussBiz;
	}

	public void setDiscussBiz(DiscussBiz discussBiz) {
		this.discussBiz = discussBiz;
	}
	public VideoBiz getVideoBiz() {
		return videoBiz;
	}
	public void setVideoBiz(VideoBiz videoBiz) {
		this.videoBiz = videoBiz;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	
	
}
