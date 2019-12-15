package com.dao;
import com.db.DBHelper;
import com.bean.AdminBean;
import java.util.*;
import java.sql.*;

public class ProductDao {

	//获取列表
	public List<ProductBean> GetList0(String strwhere,String strorder){
		String sql="select Pno, Pname, Sellprice, Vno, Vname, Lno, Lname, shelf.Shelfno, shelf.Shelfloc from product_info, shelf where	product_info.shelfno =  shelf.shelfno";
		if(!(isInvalid(strwhere)))
		{
			sql+=" where "+strwhere;
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
				cnbean.setSellprice(rs.getInt("Sellprice"));
				cnbean.setVno(rs.getInt("Vno"));
				cnbean.setLno(rs.getInt("Lno"));
				cnbean.setShelfno(rs.getInt("Shelfno"));
				cnbean.setPname(rs.getString("Pname"));
				cnbean.setVname(rs.getString("Vname"));
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

	//获取指定Pname的实体Bean
	public ProductBean GetList1(String Pname){
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

	//获取指定Shelfno的实体Bean
	public ProductBean GetList2(Int Shelfno){
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

	//获取指定Lname的实体Bean
	public ProductBean GetList3(String Lname){
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

	//获取指定Vname的实体Bean
	public ProductBean GetList4(String Vname){
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

	//获取指定Pno的实体Bean
	public ProductBean GetBean5(int Pno){
		String sql="select Pno, Pname, Sellprice, Vno, Vname, Lno, Lname, shelf.Shelfno, shelf.Shelfloc from product_info, shelf where	product_info.shelfno =  shelf.shelfno and Pno="+Pno;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		ProductBean cnbean=new ProductBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setPno(rs.getInt("Pno"));
				cnbean.setSellprice(rs.getInt("Sellprice"));
				cnbean.setVno(rs.getInt("Vno"));
				cnbean.setLno(rs.getInt("Lno"));
				cnbean.setShelfno(rs.getInt("Shelfno"));
				cnbean.setPname(rs.getString("Pname"));
				cnbean.setVname(rs.getString("Vname"));
				cnbean.setLname(rs.getString("Lname"));
				
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

	//获取指定Sellprice的实体Bean
	public ProductBean GetList6(float Sellprice){
		String sql="select Pno, Pname, Sellprice, Vno, Vname, Lno, Lname, shelf.Shelfno, shelf.Shelfloc from product_info, shelf where product_info.shelfno =  shelf.shelfno and Sellprice="+Sellprice;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		ProductBean cnbean=new ProductBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setPno(rs.getInt("Pno"));
				cnbean.setSellprice(rs.getInt("Sellprice"));
				cnbean.setVno(rs.getInt("Vno"));
				cnbean.setLno(rs.getInt("Lno"));
				cnbean.setShelfno(rs.getInt("Shelfno"));
				cnbean.setPname(rs.getString("Pname"));
				cnbean.setVname(rs.getString("Vname"));
				cnbean.setLname(rs.getString("Lname"));
				
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

	//获取指定Vno的实体Bean
	public ProductBean GetList7(int Vno){
		String sql="select Pno, Pname, Sellprice, Vno, Vname, Lno, Lname, shelf.Shelfno, shelf.Shelfloc from product_info, shelf where product_info.shelfno =  shelf.shelfno and Vno="+Vno;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		ProductBean cnbean=new ProductBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setPno(rs.getInt("Pno"));
				cnbean.setSellprice(rs.getInt("Sellprice"));
				cnbean.setVno(rs.getInt("Vno"));
				cnbean.setLno(rs.getInt("Lno"));
				cnbean.setShelfno(rs.getInt("Shelfno"));
				cnbean.setPname(rs.getString("Pname"));
				cnbean.setVname(rs.getString("Vname"));
				cnbean.setLname(rs.getString("Lname"));
				
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

	//获取指定Lno的实体Bean
	public ProductBean GetList8(int Lno){
		String sql="select Pno, Pname, Sellprice, Vno, Vname, Lno, Lname, shelf.Shelfno, shelf.Shelfloc from product_info, shelf where product_info.shelfno =  shelf.shelfno and Lno="+Lno;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		ProductBean cnbean=new ProductBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setPno(rs.getInt("Pno"));
				cnbean.setSellprice(rs.getInt("Sellprice"));
				cnbean.setVno(rs.getInt("Vno"));
				cnbean.setLno(rs.getInt("Lno"));
				cnbean.setShelfno(rs.getInt("Shelfno"));
				cnbean.setPname(rs.getString("Pname"));
				cnbean.setVname(rs.getString("Vname"));
				cnbean.setLname(rs.getString("Lname"));
				
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
	public void Add(ProductBean cnbean ShelfBean cmbean){
		String sql="insert into product_info and shelf (";
		sql+="Pno, Pname, Sellprice, Vno, Vname, Lno, Lname, shelf.Shelfno, shelf.Shelfloc";
		sql+=") values(";
		sql+=cnbean.getPno()+",’"+cnbean.getPname()+”’,”+cnbean.getSellprice()+","+cnbean.getVno()+”,’”+cnbean.getVname()+”’,”+cnbean.getLno()+”,’”+cnbean.getLname()+”’,”+cmbean.getShelfno()+”,’”+cmbean.getShelfloc()+”’”;
		sql+=")";
		sql+=“where product_info.shelfno =  shelf.shelfno”;
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
	public void Update(ProductBean cnbean ShelfBean cmbean){
		String sql="update product_info and shelf set ";
		sql+="Pno='"+cnbean.getPno()+"',";
		sql+="Pname='"+cnbean.getPname()+"',";
		sql+="Sellprice='"+cnbean.getSellprice()+"',";
		sql+="Vno='"+cnbean.getVno()+"',";
		sql+="Vname='"+cnbean.getVname()+”’,”;
		sql+="Lno='"+cnbean.getLno()+"',";
		sql+="Lname='"+cnbean.getLname()+”’,”;
		sql+="shelf.Shelfno='"+cmbean.getShelfno()+"',";
		sql+="shelf.Shelfloc='"+cmbean.getShelloc()+"'";		
		sql+="where product_info.shelfno =  shelf.shelfno";
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




