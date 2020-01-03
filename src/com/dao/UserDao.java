package com.dao;

import com.db.DBHelper;
import com.bean.UserBean;
import java.util.*;
import java.sql.*;

public class UserDao {
	
	//��֤��¼
	public String CheckLogin(String username, String password, String Type){
		String id = null;
		String sql="select * from user_info where Username='"+username+"' and Password='"+password+"' and Type='"+Type+"'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				id = rs.getString("Cno");
			}
		}
		catch(SQLException ex){}
		return id;
	}
	//��֤����
	public boolean CheckPassword(String id, String password){
		boolean ps = false;
		String sql="select * from Admin where Admin_ID='"+id+"' and Admin_Password='"+password+"'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				ps=true;
			}
		}
		catch(SQLException ex){}
		return ps;
	}

	
	//��ȡָ��ID��ʵ��Bean
	public UserBean GetBean(String id){
		String sql="select * from user_info where Cno="+id;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		UserBean cnbean=new UserBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setCno(rs.getInt("Cno"));
				cnbean.setUsername(rs.getString("Username"));
				cnbean.setPassword(rs.getString("Password"));
				cnbean.setType(rs.getString("Type"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnbean;
	}
	

	//�޸�
	public void Update(UserBean cnbean){
		String sql="update user_info set ";
		sql+="Username='"+cnbean.getUsername()+"',";
		sql+="Password='"+cnbean.getPassword()+"',";
		
		sql+=" where Cno="+cnbean.getCno()+"";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//ɾ��
	public void Delete(String strwhere){
		String sql="delete user_info where ";
		sql+=strwhere;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	//�ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//����
	public static void main(String[] args) {
		System.out.println("");
	}
	
}

