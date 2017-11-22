package com.gem.kfc.dao.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

public class BaseDAO<T> {
	 private Connection conn;
	 private PreparedStatement psmt;
	 private ResultSet rs;
	 
	protected Connection getConn(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/kfc?useUnicode=true&characterEncoding=UTF-8","root","123");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	protected void close(ResultSet rs,PreparedStatement psmt,Connection conn){
			try {
				if(rs!=null){
				rs.close();
			}if(psmt!=null){
				psmt.close();
			} if(conn!=null&&!conn.isClosed()){
				conn.close();
			}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	protected void setParams(PreparedStatement psmt,Object...params) throws SQLException{
		if(params!=null&&params.length>0){
			for(int i=0;i<params.length;i++){
				psmt.setObject(i+1,params[i]);
			}
		}
	}
	
	
	protected boolean executeUpdate (String sql,Object...params){
		conn=getConn();
		try {
			psmt=conn.prepareStatement(sql);
			setParams(psmt,params);
			return psmt.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs,psmt,conn);
		}
		return false;
	}
	public int executeUpdateReturnGeneratedKey(String sql , Object... params){
		conn=getConn();
		try {
			psmt = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
			setParams(psmt , params) ;
			int count = psmt.executeUpdate() ;
			if(count>0){
				rs = psmt.getGeneratedKeys();
				if(rs.next()){
					return rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rs, psmt, conn);
		}
		return 0 ;
	}
		

	
	protected Set<T>executeQuery(IParser<T> parser,String sql,Object...params){//�˷������ڷ���һ������set
		conn=getConn();
		try{
		psmt=conn.prepareStatement(sql);
		setParams(psmt,params);
		rs=psmt.executeQuery();
		return parser.parserRS(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs,psmt,conn);
		}
		return null;
	}

	protected T loadRS(IParser<T> parser,String sql,Object...params){
		conn=getConn();
		try {
			psmt=conn.prepareStatement(sql);
			setParams(psmt,params);
			rs=psmt.executeQuery();
			return parser.loadRS(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs,psmt,conn);
		}
		return null;		
	}
	protected Object complexQuery(IParser<T> parser,String sql,Object...params){
		conn=getConn();
		try {
			psmt=conn.prepareStatement(sql);
			setParams(psmt,params);
			rs=psmt.executeQuery();
			return parser.parseComplexRS(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs,psmt,conn);
		}
		return null;
	}
	
	
	
	
	
}
