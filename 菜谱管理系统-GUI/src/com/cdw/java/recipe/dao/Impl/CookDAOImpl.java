package com.cdw.java.recipe.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cdw.java.recipe.dao.CookDAO;
import com.cdw.java.recipe.dao.MaterialDAO;
import com.cdw.java.recipe.dao.base.BaseDAO;
import com.cdw.java.recipe.pojo.Cook;

public class CookDAOImpl extends BaseDAO implements CookDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	@Override
	public boolean updateCook(int rid,String cdetail) {
		String sql="update t_cook set detail=? where rid=?";
		return executeUpdate(sql,cdetail,rid)>0;
	}

	@Override
	public boolean delCook(int rid) {
	String sql="delete from t_cook where rid=?";
	return executeUpdate(sql, rid)>0;
	}

	@Override
	public boolean addCook(Cook cook) {
		String sql="insert into t_cook values(null,?,?,?)";
		return executeUpdate(sql, cook.getName(),cook.getDetail(),cook.getRid())>0;
	}

	@Override
	public String getCook(int rid) {
		conn=getConn();
		String sql="select *from t_cook where rid=?";		
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, rid);
			rs=psmt.executeQuery();
			if(rs.next()){
							
				return rs.getString(3);	
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs,psmt,conn);
		}
		return null;	
		}
	

}
