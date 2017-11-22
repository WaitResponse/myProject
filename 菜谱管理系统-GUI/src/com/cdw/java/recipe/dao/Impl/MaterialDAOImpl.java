package com.cdw.java.recipe.dao.Impl;

import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cdw.java.recipe.dao.MaterialDAO;
import com.cdw.java.recipe.dao.base.BaseDAO;
import com.cdw.java.recipe.pojo.Material;

public class MaterialDAOImpl extends BaseDAO implements MaterialDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	@Override
	public boolean updateMaterial(int rid,String mdetail) {
		String sql="update t_material set detail=? where rid=?";
		return executeUpdate(sql,mdetail,rid)>0;
	}

	@Override
	public boolean delMaterial(int rid) {
	String sql="delete from t_material where rid=?";
	return executeUpdate(sql, rid)>0;
	}

	@Override
	public boolean addMaterial(Material material) {
		String sql="insert into t_material values(null,?,?,?)";
		return executeUpdate(sql, material.getName(),material.getDetail(),material.getRid())>0;
	}

	@Override
	public String getMaterial(int rid) {
		conn=getConn();
		String sql="select *from t_material where rid=?";		
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1,rid);
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
