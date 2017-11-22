package com.cdw.java.recipe.pojo;

import java.sql.Date;
import java.util.List;

public class Recipe {
	private int id;
	private String name;
	private String uname;
	private Date date;
	
	

	public Recipe(){}
	

	public Recipe(int id, String name, String uname, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.uname = uname;
		this.date = date;
		
	}


	public Recipe( String name, Date date, String uname){
		super();		
		this.name = name;
		this.uname = uname;
		this.date = date;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return id+"\t"+name+"\t"+uname+"\t"+date;
	}
	
}
