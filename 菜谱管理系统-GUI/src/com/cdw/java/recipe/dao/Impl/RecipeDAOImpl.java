package com.cdw.java.recipe.dao.Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cdw.java.recipe.dao.RecipeDAO;
import com.cdw.java.recipe.dao.base.BaseDAO;
import com.cdw.java.recipe.pojo.Recipe;

public class RecipeDAOImpl extends BaseDAO implements RecipeDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	@Override
	public boolean addRecipe(Recipe recipe) {
		String sql="insert into t_recipe values(null,?,?,?)";
		return executeUpdate(sql, recipe.getName(),
				recipe.getDate(),
				recipe.getUname())>0;												
	}
	public Recipe getRecipeByname(String rname,String uname){
		conn=getConn();
		List<Recipe>recipeList=new ArrayList<Recipe>();
		String sql="select * from t_recipe where name=? and uname=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1,rname);
			psmt.setString(2,uname);
			rs=psmt.executeQuery();
			if(rs.next()){
			int id=rs.getInt(1);
			Date date=rs.getDate(3);
			return new Recipe(id,rname,uname,date);		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs,psmt,conn);
		}
		return null;
	}

	@Override
	public boolean delRecipe(int rid) {
		String sql="delete from t_recipe where id=?";
		return executeUpdate(sql, rid)>0;
		
	}

	@Override
	public List<Recipe> getRecipeList(String rname) {
		List<Recipe>recipeList=new ArrayList<Recipe>();
		String sql="select *from t_recipe where name =? ";
		conn=getConn();
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, rname);
			rs=psmt.executeQuery();
			while(rs.next()){
				int id=rs.getInt(1);
				Date date=rs.getDate(3);
				String uname=rs.getString(4);
				
				Recipe recipe=new Recipe(id,rname,uname,date);
				recipeList.add(recipe);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs,psmt,conn);
		}
		return recipeList;
	}	
	public List<Recipe> getAllRecipeList() {
		List<Recipe>allRecipeList=new ArrayList<Recipe>();
		String sql="select *from t_recipe  ";
		conn=getConn();
		try {
			psmt=conn.prepareStatement(sql);			
			rs=psmt.executeQuery();
			while(rs.next()){
				int id=rs.getInt(1);
				String name=rs.getString(2);
				Date date=rs.getDate(3);
				String uname=rs.getString(4);			
				Recipe recipe=new Recipe(id,name,uname,date);
				allRecipeList.add(recipe);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs,psmt,conn);
		}
		return allRecipeList;
	}	
	public List<Recipe> getMyRecipeList(String uname) {
		List<Recipe>myRecipeList=new ArrayList<Recipe>();
		String sql="select *from t_recipe where uname=? ";
		conn=getConn();
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, uname);
			rs=psmt.executeQuery();
			while(rs.next()){
				int id=rs.getInt(1);
				String name=rs.getString(2);
				Date date=rs.getDate(3);		
			
				Recipe recipe=new Recipe(id,name,uname,date);
				myRecipeList.add(recipe);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs,psmt,conn);
		}
		return myRecipeList;
	}	
	public String getRecipe(int rid) {
		List<Recipe>recipeList=new ArrayList<Recipe>();
		String sql="select *from t_recipe where id=? ";
		conn=getConn();
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, rid);
			rs=psmt.executeQuery();
			if(rs.next()){
				
				return rs.getString(2);		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs,psmt,conn);
		}
		return null;
	}	
	public boolean updateRecipe(int rid,Date date){
		String sql="update t_recipe set date=? where id=?";
		return executeUpdate(sql, date,rid)>0;		
	}
}
