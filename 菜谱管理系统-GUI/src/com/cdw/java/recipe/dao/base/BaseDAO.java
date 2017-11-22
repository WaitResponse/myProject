package com.cdw.java.recipe.dao.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs ;
		
	protected  Connection getConn(){
		 try {
			Class.forName("com.mysql.jdbc.Driver");			
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/recipe?useUnicode=true&characterEncoding=UTF-8","root","root");
		 }
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;		 		
	}
	protected void close(ResultSet rs,PreparedStatement psmt,Connection conn){

		try {
			if(rs!=null){
			rs.close();
			}
			if(psmt!=null){
				psmt.close();
			}
			if(conn!=null&&conn.isClosed()){
				conn.close();
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}
	}
	protected int executeUpdate(String sql,Object...params){
		conn=getConn();
		try {
			psmt=conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				psmt.setObject(i+1,params[i]);
			}
			return psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs,psmt,conn);
		}
		return 0;
	}
	protected int executeUpdateReturnGenneratedKey(String sql,Object...params){
		conn=getConn();
		
		try {
			psmt=conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				psmt.setObject(i+1,params[i]);				
			}
			int count=psmt.executeUpdate();
			if(count>0){
				rs=psmt.getGeneratedKeys();
				if(rs.next()){
					return rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs,psmt,conn);
		}
		return 0;
	}
			
	}

