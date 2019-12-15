package com.dao;
import com.db.DBHelper;
import com.bean.AdminBean;
import java.util.*;
import java.sql.*;

public class SupplierDao {

public SupplierBean Getbean(Int Prono){
		String sql="select * from Supplier where
		Prono="+Prono;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		SupplierBean cnbean=new SupplierBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setProno(rs.getInt("prono"));
				cnbean.setProname(rs.getstring("proname"));
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

public SupplierBean Getbean(String Proname){
		String sql="select * from Supplier where
		Proname="+proname;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		SupplierBean cnbean=new SupplierBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setProno(rs.getInt("prono"));
				cnbean.setProname(rs.getstring("proname"));
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