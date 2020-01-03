package com.dao;
import com.db.DBHelper;
import com.bean.*;
import java.util.*;
import java.sql.*;

public class ProductDao {

	//获取列表
	public List<ProductBean> GetList(String strwhere,String strorder){
		String sql="select Pno, Pname, Sellprice, product_info.Vno Vno, producttree.Vname Vname ,product_info.Lno Lno,  producttree.Lname Lname, shelf.Shelfno Shelfno, shelf.Shelfloc Shelfloc, Stockout_n from product_info, shelf, producttree where product_info.shelfno =  shelf.shelfno and product_info.Lno = producttree.Lno";
		if(!(isInvalid(strwhere)))
		{
			sql+=" and "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+=" order by "+strorder;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<ProductBean> list=new ArrayList<ProductBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				ProductBean cnbean=new ProductBean();
				cnbean.setPno(rs.getInt("Pno"));
				cnbean.setPname(rs.getString("Pname"));
				cnbean.setSellprice(rs.getFloat("Sellprice"));
				cnbean.setVno(rs.getInt("Vno"));
				cnbean.setVname(rs.getString("Vname"));
				cnbean.setLno(rs.getInt("Lno"));
				cnbean.setLname(rs.getString("Lname"));
				cnbean.setShelfno(rs.getInt("Shelfno"));
				cnbean.setShelfloc(rs.getString("Shelfloc"));
				cnbean.setStockout_n(rs.getInt("Stockout_n"));
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
	
	//获得商品树
	public List<ProductBean> GetTreeVnameList(String strwhere,String strorder){
		String sql="select distinct Vname, Vno from producttree where 1=1";
		if(!(isInvalid(strwhere)))
		{
			sql+=" and "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+=" order by "+strorder;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<ProductBean> list=new ArrayList<ProductBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				ProductBean cnbean=new ProductBean();
				
				cnbean.setVno(rs.getInt("Vno"));
				cnbean.setVname(rs.getString("Vname"));
				
				
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

	public List<ProductBean> GetTreeLnameList(String strwhere,String strorder){
		String sql="select distinct Lname, Lno from producttree where 1=1";
		if(!(isInvalid(strwhere)))
		{
			sql+=" and "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+=" order by "+strorder;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<ProductBean> list=new ArrayList<ProductBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				ProductBean cnbean=new ProductBean();
				
			
				cnbean.setLno(rs.getInt("Lno"));
				cnbean.setLname(rs.getString("Lname"));
				
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

	
	//获得货架信息列表
	public List<ShelfBean> GetShelfList(String strwhere,String strorder){
		String sql="select * from shelf where 1=1";
		if(!(isInvalid(strwhere)))
		{
			sql+=" and "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+=" order by "+strorder;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<ShelfBean> list=new ArrayList<ShelfBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				ShelfBean cnbean=new ShelfBean();
				
				cnbean.setVno(rs.getInt("Vno"));
				cnbean.setShelfno(rs.getInt("Shelfno"));
				cnbean.setSno(rs.getInt("Sno"));
				cnbean.setShelfloc(rs.getString("Shelfloc"));
				
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

	//获取指定Pno的实体Bean
	public ProductBean GetBean(int Pno){
		String sql="select * from product_info where Pno="+Pno;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		ProductBean cnbean=new ProductBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()) {
			cnbean.setPno(rs.getInt("Pno"));
			cnbean.setSellprice(rs.getFloat("Sellprice"));
			cnbean.setVno(rs.getInt("Vno"));
			cnbean.setLno(rs.getInt("Lno"));
			cnbean.setShelfno(rs.getInt("Shelfno"));
			cnbean.setPname(rs.getString("Pname"));
			cnbean.setStockout_n(rs.getInt("Stockout_n"));
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

	//添加
	public void Add(ProductBean cnbean){
		String sql="insert into product_info (";
		sql+="Pname, Sellprice, Vno, Lno, Shelfno, Stockout_n";
		sql+=") values(";
		sql+="'"+cnbean.getPname()+"',"+cnbean.getSellprice()+","+cnbean.getVno()+","+cnbean.getLno()+","+cnbean.getShelfno()+","+cnbean.getStockout_n();
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
	//修改
	public void Update(ProductBean cnbean){
		String sql="update product_info set ";
		sql+="Pname='"+cnbean.getPname()+"',";
		sql+="Sellprice="+cnbean.getSellprice()+",";
		sql+="Vno="+cnbean.getVno()+",";
		sql+="Lno="+cnbean.getLno()+",";
		sql+="Shelfno="+cnbean.getShelfno()+",";
		sql+="Stockout_n="+cnbean.getStockout_n();
		sql+="where Pno="+cnbean.getPno();
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
	//删除
	public void Delete(String strwhere){
		String sql="delete product_info where ";
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

	
	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//测试
	public static void main(String[] args) {
		System.out.println("");
	}
	
}




