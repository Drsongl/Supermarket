package com.dao;
import com.db.DBHelper;
import com.bean.AdminBean;
import java.util.*;
import java.sql.*;

public class ReplenishDao {
	

	public ReplenishBean GetList(Date Idate){
		String sql="select Ino, Proname, Pname, Vname, 
        Lname, Grossprice, Sno, Idate from  Replenish,  
        Product, Supplier where Product.Pno=Replenish.Pno 
        and Product.Prono = Supplier.Prono and Idate="+Idate;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<ReplenishBean> list=new ArrayList<ReplenishBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setIno(rs.getInt("ino"));
				cnbean.setProname(rs.getstring("proname"));
				cnbean.setPname(rs.getString("pname"));
				cnbean.setVname(rs.getString("vname"));
				cnbean.setLname(rs.getString("lname"));
				cnbean.setSno(rs.getInt("sno"));
				cnbean.setIdate(rs.getDate("idate"));
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

	public ReplenishBean GetList(Int Sno){
		String sql="select Ino, Proname, Pname, Vname, 
        Lname, Grossprice, Sno, Idate from  Replenish,  
        Product, Supplier where Product.Pno=Replenish.Pno 
        and Product.Prono = Supplier.Prono and Sno="+sno;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<ReplenishBean> list=new ArrayList<ReplenishBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setIno(rs.getInt("ino"));
				cnbean.setProname(rs.getstring("proname"));
				cnbean.setPname(rs.getString("pname"));
				cnbean.setVname(rs.getString("vname"));
				cnbean.setLname(rs.getString("lname"));
				cnbean.setSno(rs.getInt("sno"));
				cnbean.setIdate(rs.getDate("idate"));
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


public ProductBean GetList(String Pname){
		String sql="select Ino, Proname, Pname, Vname, 
        Lname, Grossprice, Sno, Idate from  Replenish,  
        Product, Supplier where Product.Pno=Replenish.Pno 
        and Product.Prono = Supplier.Prono and Pname="+Pname;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<ProductBean> list=new ArrayList<ProductBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setIno(rs.getInt("ino"));
				cnbean.setProname(rs.getstring("proname"));
				cnbean.setPname(rs.getString("pname"));
				cnbean.setVname(rs.getString("vname"));
				cnbean.setLname(rs.getString("lname"));
				cnbean.setSno(rs.getInt("sno"));
				cnbean.setIdate(rs.getDate("idate"));
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


	public ProductBean GetList(Int Lno){
		String sql="select Ino, Proname, Pname, Vname, 
        Lname, Grossprice, Sno, Idate from  Replenish,  
        Product, Supplier where Product.Pno=Replenish.Pno 
        and Product.Prono = Supplier.Prono and Lno="+lno;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<ProductBean> list=new ArrayList<ProductBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setIno(rs.getInt("ino"));
				cnbean.setProname(rs.getstring("proname"));
				cnbean.setPname(rs.getString("pname"));
				cnbean.setVname(rs.getString("vname"));
				cnbean.setLname(rs.getString("lname"));
				cnbean.setSno(rs.getInt("sno"));
				cnbean.setIdate(rs.getDate("idate"));
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




//添加进货
	public void Add(ReplenishBean cnbean){
		String sql="insert into Replenish (";
		sql+="Ino,Prono,Pno,Inum,Grossprice,Sno,Idate";
		sql+=") values(";
		sql+=cnbean.getIno()+","+cnbean.getProno()+","+cnbean.getPno()+","+cnbean.getInum()+","+cnbean.getGrossprice()+","+cnbean.getSno()+",'"cnbean.getIdate()+"'";
		sql+=")";
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
	