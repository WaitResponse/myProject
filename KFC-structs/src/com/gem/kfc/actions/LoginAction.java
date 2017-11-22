package com.gem.kfc.actions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.gem.kfc.dao.UserDAO;
import com.gem.kfc.dao.Impl.UserDAOImpl;
import com.gem.kfc.pojo.User;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String login(){
		HttpServletResponse response =ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		//1.获取loginId,pwd
		UserDAO userDAO=new UserDAOImpl();
		User currUser=userDAO.getUser(user.getLoginId(), user.getPwd());
		if(currUser!=null){
			ActionContext.getContext().getSession().put("currUser",currUser);
			return "preIndex";
		}else{
			PrintWriter out;
			try {		
				out = response.getWriter();
				out.println("<script language='javascript'>");
				out.println("alert('用户名或密码不对，登录失败！');");
				out.println("window.history.back();");
				out.println("</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
		return null;
	}

	public String loginOut(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.removeAttribute("currUser");
		session.removeAttribute("cartItemMap");
		session.invalidate();
		return "login_page";
	}
	/*public String regist(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		
		
		

	//1.获取用户信息，封装成一个user
	    	String loginId=request.getParameter("loginId");
			String pwd=request.getParameter("pwd2");
			String nickName=request.getParameter("nickName");
			String realName=request.getParameter("realName");
			int balance=4396;
			User user=new User(loginId,pwd,nickName,realName,balance);
			
			//2.调用addUser方法
			UserDAO userDAO=new UserDAOImpl();
			boolean flag=userDAO.addUser(user);

			out.println("<script language='javascript'>");
			out.println("alert('"+(flag? "注册成功!":"注册失败!")+"')");
			out.println("window.location.href='login.jsp';");
			out.println("</script>");
			out.flush();
		
	}*/
}
