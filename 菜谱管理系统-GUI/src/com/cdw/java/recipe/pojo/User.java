package com.cdw.java.recipe.pojo;

import java.util.List;

public class User {
	private int id;
	private String loginid;
	private String pwd;
	private String nickName;
	
	private List<Recipe>recipeList;

	
	public User(){}

	public User( String loginid, String pwd, String nickName) {
		super();	
		this.loginid = loginid;
		this.pwd = pwd;
		this.nickName = nickName;	
	}
	

	public User(int id, String loginid, String pwd, String nickName) {
		super();
		this.id = id;
		this.loginid = loginid;
		this.pwd = pwd;
		this.nickName = nickName;
	
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}



	public List<Recipe> getRecipeList() {
		return recipeList;
	}

	public void setRecipeList(List<Recipe> recipeList) {
		this.recipeList = recipeList;
	}

	
}
