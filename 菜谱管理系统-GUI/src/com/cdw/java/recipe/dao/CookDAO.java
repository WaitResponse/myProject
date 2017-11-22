package com.cdw.java.recipe.dao;

import com.cdw.java.recipe.pojo.Cook;

public interface CookDAO {
	boolean updateCook(int rid,String cdetail);
	boolean delCook(int rid);
	boolean addCook(Cook cook);
	String getCook(int rid);
}
