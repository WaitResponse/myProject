package com.cdw.java.recipe.dao;

import java.sql.Date;
import java.util.List;

import com.cdw.java.recipe.pojo.Recipe;

public interface RecipeDAO {
	
	boolean addRecipe(Recipe recipe);
	
	boolean delRecipe(int rid);
	
	List<Recipe> getRecipeList(String rname);//实现搜索功能，通过名称搜索菜品
	
	List<Recipe>getAllRecipeList();//实现查看所有菜品功能
	
	String getRecipe(int rid);//查看具体的菜品,但是只返回名称(名称，配料，和做法),这一步和getMaterial和getCook同步
	
	List<Recipe>getMyRecipeList(String uname);//实现查看我的菜品功能
	
	 Recipe getRecipeByname(String rname,String uname);
	boolean updateRecipe(int rid,Date date);
	
	
	
}
