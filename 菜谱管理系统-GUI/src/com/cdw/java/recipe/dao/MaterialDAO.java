package com.cdw.java.recipe.dao;

import com.cdw.java.recipe.pojo.Material;

public interface MaterialDAO {
	boolean updateMaterial(int rid,String mdetail);
	boolean delMaterial(int rid);
	boolean addMaterial(Material material);
	String getMaterial(int rid);
}
