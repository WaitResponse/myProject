package com.cdw.java.recipe.dao;

import com.cdw.java.recipe.pojo.User;

public interface UserDAO {
	
	User Login(String loginId,String pwd);
	String Regist(String loginId,String pwd,String nickName);
	boolean addUser(User user);
}
