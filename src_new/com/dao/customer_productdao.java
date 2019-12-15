package com.dao;

import com.db.DBHelper;
import com.bean.AdminBean;
import java.util.*;
import java.sql.*;

public class customer_ProductDao {

    //获取所有列表
  

	public ProductBean GetAllList(final String Pno){
		final String sql=
		"select Pno,Pname,Sellprice,Shelfno,Shelfloc from product_info,shelf where product_info.Shelfno=shelf.Shelfno ";
		Statement stat = null;
		ResultSet rs = null;
		final Connection conn = new DBHelper().getConn();
		final List<ProductBean> list=new ArrayList<ProductBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				ProductBean cnbean=new ProductBean();
				cnbean.setPno(rs.getInt("pno"));
				cnbean.setPname(rs.getString("pname"));o
				cnbean.setSellprice(rs.getString("sellprice"));
				cnbean.setShelfno(rs.getInt("shelfno"));
				cnbean.setShelfloc(rs.getString("shelfloc"));
				
				list.add(cnbean);
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (final SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
    }

	private void setSellprice(String string) {
	}

	// 商品信息 （商品名称 查询）
	public ProductBean GetList(final String Pname) {
		final String sql = "select Pno, Pname,Sellprice, Shelfno, Shelfloc from product_info,shelf where product_info.Shelfno=shelf.Shelfno and Pname="
				+ Pname;
		Statement stat = null;
		ResultSet rs = null;
		final Connection conn = new DBHelper().getConn();
		final List<ProductBean> list = new ArrayList<ProductBean>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				ProductBean cnbean=new ProductBean()
				cnbean.setPno(rs.getInt("pno"));
				cnbean.setPname(rs.getString("pname"));
				cnbean.setSellprice(rs.getString("sellprice"));
				cnbean.setShelfno(rs.getInt("shelfno"));
				cnbean.setShelfloc(rs.getString("shelfloc"));
				
				list.add(cnbean);
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (final SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	// 商品信息 （商品pno查询）
	public ProductBean GetList(final String Pname) {
		final String sql = "select Pno, Pname,Sellprice, Shelfno, Shelfloc from product_info,shelf where product_info.Shelfno=shelf.Shelfno and Pno="
				+ Pno;
		Statement stat = null;
		ResultSet rs = null;
		final Connection conn = new DBHelper().getConn();
		final List<ProductBean> list = new ArrayList<ProductBean>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				ProductBean cnbean=new ProductBean()
				cnbean. setPno(rs.getInt("pno"));
				cnbean.setPname(rs.getString("pname"));
				cnbean.setSellprice(rs.getString("sellprice"));
				cnbean.setShelfno(rs.getInt("shelfno"));
				cnbean.setShelfloc(rs.getString("shelfloc"));
				
				list.add(cnbean);
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (final SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
    }    
}


