package com.gem.qqzone.actions;

import org.hibernate.Hibernate;
import com.gem.qqzone.biz.UserBiz;
import com.gem.qqzone.pojo.User;
import com.opensymphony.xwork2.ActionContext;


public class UserAction{
	
	private User user ;
	private UserBiz userBiz=null;
	
	public String login(){
		
		User currUser = userBiz.login(user.getLoginId(), user.getPwd());
		if(currUser!=null){
			currUser = userBiz.getUser(currUser.getId());//��ʱcurrUser�ǳ־�̬
			Hibernate.initialize(currUser.getFriends());
			Hibernate.initialize(currUser.getTopics());//ǿ�Ƽ��غ�currUser�����ĺ��Ѻ���־
		//	currUser.getFriends().size();
		//	currUser.getTopics().size();
			ActionContext.getContext().getSession().put("currUser", currUser);
			ActionContext.getContext().getSession().put("currFriend", currUser);
			return "success";
		}
		return "fail";
	}

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
	
}
