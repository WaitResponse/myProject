package com.cdw.java.recipe.dao;

import java.sql.Date;
import java.util.List;

import com.cdw.java.recipe.pojo.Recipe;

public interface RecipeDAO {
	
	boolean addRecipe(Recipe recipe);
	
	boolean delRecipe(int rid);
	
	List<Recipe> getRecipeList(String rname);//ʵ���������ܣ�ͨ������������Ʒ
	
	List<Recipe>getAllRecipeList();//ʵ�ֲ鿴���в�Ʒ����
	
	String getRecipe(int rid);//�鿴����Ĳ�Ʒ,����ֻ��������(���ƣ����ϣ�������),��һ����getMaterial��getCookͬ��
	
	List<Recipe>getMyRecipeList(String uname);//ʵ�ֲ鿴�ҵĲ�Ʒ����
	
	 Recipe getRecipeByname(String rname,String uname);
	boolean updateRecipe(int rid,Date date);
	
	
	
}
