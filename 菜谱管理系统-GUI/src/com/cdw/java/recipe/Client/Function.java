package com.cdw.java.recipe.Client;

import java.sql.Date;
import java.util.List;

import com.cdw.java.recipe.dao.CookDAO;
import com.cdw.java.recipe.dao.MaterialDAO;
import com.cdw.java.recipe.dao.RecipeDAO;
import com.cdw.java.recipe.dao.UserDAO;
import com.cdw.java.recipe.dao.Impl.CookDAOImpl;
import com.cdw.java.recipe.dao.Impl.MaterialDAOImpl;
import com.cdw.java.recipe.dao.Impl.RecipeDAOImpl;
import com.cdw.java.recipe.dao.Impl.UserDAOImpl;
import com.cdw.java.recipe.pojo.Cook;
import com.cdw.java.recipe.pojo.Material;
import com.cdw.java.recipe.pojo.Recipe;

public class Function {
	UserDAO userDAO=new UserDAOImpl();
	RecipeDAO recipeDAO=new RecipeDAOImpl();
	MaterialDAO materialDAO=new MaterialDAOImpl();
	CookDAO cookDAO=new CookDAOImpl();
	
	
	//1.��ʾ���в�Ʒ
	public List<Recipe> ShowAll(){		
		List<Recipe>allRecipeList= recipeDAO.getAllRecipeList();
		return allRecipeList;
	}
	
	//2.ɾ���ҵĲ�Ʒ������"ɾ���ɹ�"��"ɾ��ʧ��"
	public boolean DelRecipe(int rid){		
		boolean flag1=recipeDAO.delRecipe(rid);
		return flag1;
	}
	public boolean DelMaterial(int rid){
		boolean flag2=materialDAO.delMaterial(rid);
		return flag2;
	}
	public boolean DelCook(int rid){
		boolean flag3=cookDAO.delCook(rid);
		return flag3;
	}
	
	
	
	//3.��ʾ�ҵĲ�Ʒ
	public List<Recipe>ShowMy(String uname){
		List<Recipe>myRecipeList= recipeDAO.getMyRecipeList(uname);
		return myRecipeList;
	}
	//4.�޸�ʱ��(���������޸�),������������������
	public boolean UpdateRecipe(int rid,Date date){	
		boolean flag4=recipeDAO.updateRecipe(rid,date);
		return flag4;
	}
	public boolean UpdateMaterial(int rid,String detail){
		boolean flag5=materialDAO.updateMaterial(rid,detail);
		return flag5;
	}
	public boolean UpdateCook(int rid,String detail){
		boolean flag6=cookDAO.updateCook(rid,detail);
		return flag6;
	}

		
	//5.ͨ�������������в�Ʒ
	public List<Recipe>ShowRecipeList(String rname){
		List<Recipe>recipeList=recipeDAO.getRecipeList(rname);
		return recipeList;
	}
	//6.�ϴ�����,�ϴ�ʱ��,������������������
	public boolean AddRecipe(Recipe recipe){
		boolean flag7=recipeDAO.addRecipe(recipe);	
		return flag7;
	}
	public boolean AddMaterial(Material material){
		boolean flag8=materialDAO.addMaterial(material);
		return flag8;
	}
	public boolean AddCook(Cook cook){
		boolean flag9=cookDAO.addCook(cook);
		return flag9;
	}

	
	//7.��ʾ��ϸ�Ĳ�����������������������
	public String getRecipe(int rid){
		String rname=recipeDAO.getRecipe(rid);
		return rname;
	}
	public String getMaterial(int rid){
	String materialDetail=materialDAO.getMaterial(rid);
	return materialDetail;
	}
	public String getCook(int rid){
		String cookDetail=cookDAO.getCook(rid);
		return cookDetail;
	}
	
}
