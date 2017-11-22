package com.gem.xianzhi.pojo;

import java.util.Date;
import java.util.Set;

public class News {
	private int id;
	private String title;
	private String content;
	private Date date;
	private int visitCount;// 访问数量
	private String audit;// 是否经过审核
	private String img;// 新闻截图(视频截图)
	private int discussCount;//评论数量
	
	private Classify classify;//新闻分类
	private User author;
	private Set<Discuss>discuss;//评论	
	private FocusNews focusNews;// 焦点图
	
	public News(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(int visitCount) {
		this.visitCount = visitCount;
	}

	public String getAudit() {
		return audit;
	}

	public void setAudit(String audit) {
		this.audit = audit;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getDiscussCount() {
		return discussCount;
	}

	public void setDiscussCount(int discussCount) {
		this.discussCount = discussCount;
	}

	public Classify getClassify() {
		return classify;
	}

	public void setClassify(Classify classify) {
		this.classify = classify;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Set<Discuss> getDiscuss() {
		return discuss;
	}

	public void setDiscuss(Set<Discuss> discuss) {
		this.discuss = discuss;
	}

	public FocusNews getFocusNews() {
		return focusNews;
	}

	public void setFocusNews(FocusNews focusNews) {
		this.focusNews = focusNews;
	}

	
}
