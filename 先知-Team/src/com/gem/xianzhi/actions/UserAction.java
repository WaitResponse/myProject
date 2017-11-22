package com.gem.xianzhi.actions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.gem.xianzhi.Biz.NewsBiz;
import com.gem.xianzhi.Biz.UserBiz;
import com.gem.xianzhi.Biz.UserDetailBiz;
import com.gem.xianzhi.pojo.News;
import com.gem.xianzhi.pojo.User;
import com.gem.xianzhi.pojo.UserDetail;
import com.opensymphony.xwork2.ActionContext;

public class UserAction {
	private User user;
	private int currPage;
	private String keyword;
	private UserBiz userBiz;
	private NewsBiz newsBiz;
	private String Msg;
	private News news;
	private UserDetail userDetail;
	private UserDetailBiz userDetailBiz;
	//后台登录(同时加载所用户列表)
	public String backStageLogin(){//后台管理员登录
		User Administrator=userBiz.login(user.getLoginId());
		
		if(Administrator!=null&&Administrator.getType().equals("管理员")&&Administrator.getPwd().equals(user.getPwd())){
			ActionContext.getContext().getSession().put("Administrator", Administrator);
			if(currPage<=0){
				currPage=1;
			}
			if(keyword==null){
				keyword="";
			}
			int pageSize = 10;
			int pageCount = userBiz.getUserCount(keyword,pageSize);
			ActionContext.getContext().getSession().put("pageCount", pageCount);
			
			//如果当前页数大于总页数
			if(currPage>pageCount){
				currPage--;
			}
			ActionContext.getContext().getSession().put("currPage", currPage);
			List<User>userList = userBiz.getUserList(keyword, pageSize, currPage);
			ActionContext.getContext().getSession().put("userList", userList);
			return "bgLoginSuccess";
		}else{
			String msg="用户不存在或密码错误";
			ActionContext.getContext().getSession().put("msg", msg);
			return "bgLoginFail";
		}	
	}
	//前台登录
	public String login(){
		Msg = "";
		boolean flag = true ;
		User currUser = userBiz.login(user.getLoginId());
		if(currUser==null||currUser.getType().equals("管理员")){
			Msg = "用户不存在";
			flag = false ; 
		}else if(!currUser.getPwd().equals(user.getPwd())){
			Msg = "密码错误";
			flag = false ; 
		}else if(currUser.getState().equals("封禁")){
			Msg = "用户被封禁";
			flag = false ; 
		}
		if(flag){
			ActionContext.getContext().getSession().put("currUser", currUser);
			ActionContext.getContext().getSession().put("otherUser", currUser);//用来区别当前用户和其它用户
			return "loginSuccess";
		}else{
			ActionContext.getContext().put("Msg", Msg);
			return "loginFail";
		}	
	}
	
	
	//加载所有用户
	public String preIndex(){
	
		if(currPage<=0){
			currPage=1;
		}
		if(keyword==null){
			keyword="";
		}
		int pageSize = 10;
		int pageCount = userBiz.getUserCount(keyword,pageSize);
		ActionContext.getContext().getSession().put("pageCount", pageCount);
		
		//如果当前页数大于总页数
		if(currPage>pageCount){
			currPage--;
		}
		ActionContext.getContext().getSession().put("currPage", currPage);
		List<User>userList = userBiz.getUserList(keyword, pageSize, currPage);
		ActionContext.getContext().getSession().put("userList", userList);			
			return "loadAllSuccess";
	}
	
	//用户封禁和解封
	public String bannedAndDeblock(){
		User newUser = userBiz.getUser(user.getId());
		if(newUser.getState().equals("封禁")){
			newUser.setState("正常");
		}else{
			newUser.setState("封禁");
		}	
		userBiz.update(newUser);
		return "bdSuccess";
	}
	
	public String userType(){
		if(currPage<=0){
			currPage=1;
		}
		if(keyword==null){
			keyword="";
		}
		int pageSize = 10;
		int pageCount = userBiz.getUserCountByType(keyword,pageSize);
		ActionContext.getContext().getSession().put("pageCount", pageCount);
		//如果当前页数大于总页数
		if(currPage>pageCount){
			currPage--;
		}
		ActionContext.getContext().getSession().put("currPage", currPage);
		List<User>userList = userBiz.getUserByType(keyword, pageSize, currPage);
		ActionContext.getContext().getSession().put("userList", userList);
			return "loadAllSuccess";
	}
	//用户注册
	public String regist() {
		if(userBiz.getUserByLN(user.getLoginId(), user.getNickName())==null){//loginId和昵称没有重复
			user.setType("普通用户");
			user.setState("正常");
			user.setUserDetail(userDetail);
			userDetail.setUser(user);
			userBiz.add(user);						
			userDetailBiz.add(userDetail);
			Msg = "注册成功!";
			ActionContext.getContext().put("Msg", Msg);
			return "registSuccess";
		}else{
			Msg = "账号或昵称已被使用";
			ActionContext.getContext().put("Msg", Msg);//保存在request作用域
			return "registFail";
		}		
	}
	//修改用户个人资料
	public String updateUser(){
		userBiz.update(user);
		userDetail.setId(user.getId());
		userDetailBiz.update(userDetail);
		//更新之后再找出来
		User currUser = userBiz.getUser(user.getId());
		currUser.setUserDetail(userDetail);
		ActionContext.getContext().getSession().put("currUser", currUser);
		ActionContext.getContext().getSession().put("otherUser", currUser);
		return "updateSuccess";
	}
	//收藏新闻
		public String collectionNews(){
			User currUser =(User) ActionContext.getContext().getSession().get("currUser");
			User user1 = userBiz.getUser(currUser.getId());
			News news1 = newsBiz.getNews(news.getId());
			Set<News>newsSet = new HashSet<News>();
			newsSet.add(news1);
			user1.setCollectNews(newsSet);
			userBiz.add(user1);
			User user = userBiz.getUser(currUser.getId());
			Set<News> collection = currUser.getCollectNews();
			ActionContext.getContext().getSession().put("collectNews", collection);
			return "loadSuccess";
		}
		/*public String removeCollection(){
			userBiz.removeCollectNews(user.getId(),news.getId());
			User currUser = userBiz.getUser(user.getId());
			Set<News> collection = currUser.getCollectNews();
			ActionContext.getContext().getSession().put("collectNews", collection);
			return "loadSuccess";
		}
	*/
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserBiz getUserBiz() {
		return userBiz;
	}

	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
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

	public String getMsg() {
		return Msg;
	}
	public void setMsg(String msg) {
		Msg = msg;
	}
	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public UserDetailBiz getUserDetailBiz() {
		return userDetailBiz;
	}

	public void setUserDetailBiz(UserDetailBiz userDetailBiz) {
		this.userDetailBiz = userDetailBiz;
	}
	public NewsBiz getNewsBiz() {
		return newsBiz;
	}
	public void setNewsBiz(NewsBiz newsBiz) {
		this.newsBiz = newsBiz;
	}
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	
}
