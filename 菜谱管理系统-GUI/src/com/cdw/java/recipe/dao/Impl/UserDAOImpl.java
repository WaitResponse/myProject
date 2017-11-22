package com.cdw.java.recipe.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.cdw.java.recipe.Client.PopupFrame;
import com.cdw.java.recipe.dao.UserDAO;
import com.cdw.java.recipe.dao.base.BaseDAO;
import com.cdw.java.recipe.pojo.User;

public class UserDAOImpl extends BaseDAO implements UserDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	
	public User Login(String loginId, String pwd) {
		conn=getConn();
		String sql="select *from t_user where loginid=? and pwd=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1,loginId);
			psmt.setString(2,pwd);
			rs=psmt.executeQuery();
			if(rs.next()){
				int id=rs.getInt(1);
				String nickName=rs.getString(4);
				
			return new User(id,loginId,pwd,nickName);		
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			close(rs,psmt,conn);
		}
		return null;
	}
	public String Regist(String loginId,String pwd,String nickName){
		conn=getConn();
		String sql="select * from t_user where loginid=? and nickName=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, loginId);
			psmt.setString(2,nickName);
			rs=psmt.executeQuery();
			if(rs.next()){	
				String loginId1=rs.getString(2);
				String nickName1=rs.getString(4);
				if(loginId1.equals(loginId)||nickName1.equals(nickName)){
					return "ID或昵称已被占用,请重新输入";
				}				
			}else {
				User user=new User(loginId,pwd,nickName);
				boolean flag=addUser(user);
				if(flag){
				return "注册成功!";
				}else{
					return "注册失败!";	
				}
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean addUser(User user) {
		String sql="insert into t_user values(null,?,?,?)";
		return executeUpdate(sql, user.getLoginid(),user.getPwd(),user.getNickName())>0;		
	}

}
