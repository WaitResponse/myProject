package com.cdw.java.recipe.pojo;

public class Cook {
	private int id;
	private String name;
	private String detail;
	private int rid;
	
	public Cook(){}

	

	public Cook(int id, String name, String detail, int rid) {
		super();
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.rid = rid;
	}



	public Cook(String name, String detail, int rid) {
		super();
		this.name = name;
		this.detail = detail;
		this.rid = rid;
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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}



	public int getRid() {
		return rid;
	}



	public void setRid(int rid) {
		this.rid = rid;
	}


}
