package com.gem.xianzhi.actions;

import java.util.Date;
import java.util.HashSet;
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

public class preIndexAction {
	private NewsBiz newsBiz;
	private UserBiz userBiz;
	private VideoBiz videoBiz;
	private Video video;
	private ClassifyBiz classifyBiz;
	private DiscussBiz discussBiz;
	private Classify classify;
	private News news;
	private Discuss discuss;
	
	//首页获取新闻列表
	public String Index(){
		List<News>newsList = newsBiz.getNewsList();
		for(News news01:newsList){
			news01.getAuthor().getNickName();
		}
		List<Classify> classifyList = classifyBiz.getClassifyList();
		List<News>hotNewsList = newsBiz.hotNewsList();
		List<Video>hotVideoList = videoBiz.getHotVideoList();
		ActionContext.getContext().getSession().put("newsList", newsList);
		ActionContext.getContext().getSession().put("hotVideoList", hotVideoList);
		ActionContext.getContext().getSession().put("hotNewsList", hotNewsList);
		ActionContext.getContext().getSession().put("classifyList", classifyList);//导航栏获取分类
		return "loadNewsListSuccess";
	}
	//根据分类获取新闻列表
	public String getNewsListByType(){
		Classify classify1 = classifyBiz.getClassify(classify.getId());
		ActionContext.getContext().put("currClassify", classify1);
		Set<News> newsList = classify1.getNews();	
		ActionContext.getContext().getSession().put("newsList", newsList);
		return "loadClassifySuccess";
	}
	
	//根据新闻id获取新闻详情 (每次点击访问量+1)
	public String getNewsDetail(){
		News news1 = newsBiz.getNews(news.getId());
		news1.getClassify().getName();
	//	List<News>fabuList = newsBiz.getfabuNewsList(author.getId());
	   Set<News>fabuList = news1.getAuthor().getNews();
		for(News news2:fabuList){
			news2.getTitle();
		}		
		
		Set<Discuss>discussSet = news1.getDiscuss();//加载评论
		for(Discuss discuss : discussSet){
			Hibernate.initialize(discuss.getReply());//加载每条评论的回复
			discuss.getAuthor().getHeadImg();//加载评论作者的头像
		}
		news1.setVisitCount(news1.getVisitCount()+1);
		newsBiz.update(news1);
		ActionContext.getContext().getSession().put("news", news1);
		ActionContext.getContext().getSession().put("fabuSet",fabuList  );
		ActionContext.getContext().getSession().put("discussSet", discussSet);
		return "getDetailSuccess";
	}
	//添加评论
	public String addDiscuss(){
		News news = (News)ActionContext.getContext().getSession().get("news");
		User author = (User)ActionContext.getContext().getSession().get("currUser");
		/*System.out.println(discuss.getContent()+"=============");
		System.out.println(news.getTitle()+"============");*/
		discuss.setNews(news);
		discuss.setDate(new Date());
		discuss.setAuthor(author);
		discuss.setCount(0);
		discuss.setReplyCount(0);
		int id = discussBiz.addDiscuss(discuss);
		if(id!=0){
			return "addDiscussSuccess";
		}else{
			ActionContext.getContext().put("msg", "发表评论失败");
			return "addDiscussFail";
		}
	}
	public String getVideoList(){
		List<Video>videoList = videoBiz.getVideoList();
		ActionContext.getContext().getSession().put("videoList1", videoList);
		return "loadVideoListSuccess";
	}
	//查看视频，每次点击点击量+1
	public String getVideoDetail(){
		Video video1 = videoBiz.getVideo(video.getId());
		Set<News>fabuList = video1.getAuthor().getNews();
		for(News news2:fabuList){
			news2.getTitle();
		}	
		video1.setClickCount(video1.getClickCount()+1);
		videoBiz.update(video1);
		ActionContext.getContext().getSession().put("fabuSet",fabuList);
		ActionContext.getContext().getSession().put("video1", video1);
		return "loadVideoSuccess";
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

	public DiscussBiz getDiscussBiz() {
		return discussBiz;
	}

	public void setDiscussBiz(DiscussBiz discussBiz) {
		this.discussBiz = discussBiz;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public Discuss getDiscuss() {
		return discuss;
	}

	public void setDiscuss(Discuss discuss) {
		this.discuss = discuss;
	}
	public Classify getClassify() {
		return classify;
	}
	public void setClassify(Classify classify) {
		this.classify = classify;
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
