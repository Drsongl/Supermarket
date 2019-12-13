package com.dao;
import com.db.DBHelper;
import com.bean.AdminBean;
import java.util.*;
import java.sql.*;

public class ProductDao {

	public ProductBean GetList(String Pname){
		String sql="select Pno, Pname, Vno, Vname, Lno, 
        Lname, Sellprice, Shelfno, Shelfloc from Product
		where Pname="+Pname;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<ProductBean> list=new ArrayList<ProductBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setPno(rs.getInt("pno"));
				cnbean.setPname(rs.getstring("pname"));
				cnbean.setVno(rs.getInt("vno"));
				cnbean.setVname(rs.getString("vname"));
				cnbean.setLno(rs.getInt("lno"));
				cnbean.setLname(rs.getString("lname"));
				cnbean.setShelfno(rs.getInt("shelfno"));
				cnbean.setShelfloc(rs.getString("shelfloc"));
				cnbean.setSellprice(rs.getString("sellprice"));
				list.add(cnbean);
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
		return list;
	}


public ProductBean GetList(Int Shelfno){
		String sql="select Pno, Pname, Vno, Vname, Lno, 
        Lname, Sellprice, Shelfno, Shelfloc from Product
		where Shelfno="+shelfno;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<ProductBean> list=new ArrayList<ProductBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setPno(rs.getInt("pno"));
				cnbean.setPname(rs.getstring("pname"));
				cnbean.setVno(rs.getInt("vno"));
				cnbean.setVname(rs.getString("vname"));
				cnbean.setLno(rs.getInt("lno"));
				cnbean.setLname(rs.getString("lname"));
				cnbean.setShelfno(rs.getInt("shelfno"));
				cnbean.setShelfloc(rs.getString("shelfloc"));
				cnbean.setSellprice(rs.getString("sellprice"));
				list.add(cnbean);
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
		return list;
	}


	public ProductBean GetList(String Lname){
		String sql="select Pno, Pname, Vno, Vname, Lno, 
        Lname, Sellprice, Shelfno, Shelfloc from Product
		where Lname="+lname;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<ProductBean> list=new ArrayList<ProductBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setPno(rs.getInt("pno"));
				cnbean.setPname(rs.getstring("pname"));
				cnbean.setVno(rs.getInt("vno"));
				cnbean.setVname(rs.getString("vname"));
				cnbean.setLno(rs.getInt("lno"));
				cnbean.setLname(rs.getString("lname"));
				cnbean.setShelfno(rs.getInt("shelfno"));
				cnbean.setShelfloc(rs.getString("shelfloc"));
				cnbean.setSellprice(rs.getString("sellprice"));
				list.add(cnbean);
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
		return list;
	}


	public ProductBean GetList(String Vname){
		String sql="select Pno, Pname, Vno, Vname, Lno, 
        Lname, Sellprice, Shelfno, Shelfloc from Product
		where Vname="+vname;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<ProductBean> list=new ArrayList<ProductBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setPno(rs.getInt("pno"));
				cnbean.setPname(rs.getstring("pname"));
				cnbean.setVno(rs.getInt("vno"));
				cnbean.setVname(rs.getString("vname"));
				cnbean.setLno(rs.getInt("lno"));
				cnbean.setLname(rs.getString("lname"));
				cnbean.setShelfno(rs.getInt("shelfno"));
				cnbean.setShelfloc(rs.getString("shelfloc"));
				cnbean.setSellprice(rs.getString("sellprice"));
				list.add(cnbean);
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
		return list;
	}