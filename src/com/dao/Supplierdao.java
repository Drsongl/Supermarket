package com.dao;
import com.db.DBHelper;
import com.bean.*;
import java.util.*;
import java.sql.*;

public class SupplierDao {
	
	public List<SupplierBean> GetList(String strwhere,String strorder){
		String sql="select * from supplier";
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
		List<SupplierBean> list=new ArrayList<SupplierBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				SupplierBean cnbean=new SupplierBean();
				
				cnbean.setProno(rs.getInt("Prono"));
				cnbean.setProname(rs.getString("Proname"));
				
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

	public SupplierBean Getbean1(Int Prono){
			String sql="select * from supplier where Prono="+Prono;
			Statement stat = null;
			ResultSet rs = null;
			Connection conn = new DBHelper().getConn();
			SupplierBean cnbean=new SupplierBean();
			try{
				stat = conn.createStatement();
				rs = stat.executeUpdate(sql);
				cnbean.setProno(rs.getInt("Prono"));
				cnbean.setProname(rs.getString("Proname"));
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
	
	public SupplierBean Getbean2(String Proname){
			String sql="select * from supplier where Proname='"+Proname+"'";
			Statement stat = null;
			ResultSet rs = null;
			Connection conn = new DBHelper().getConn();
			SupplierBean cnbean=new SupplierBean();
			try{
				stat = conn.createStatement();
				rs = stat.executeUpdate(sql);
				cnbean.setProno(rs.getInt("Prono"));
				cnbean.setProname(rs.getString("Proname"));
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
	
	//判断是否空值
		private boolean isInvalid(String value) {
			return (value == null || value.length() == 0);
		}
		
		//测试
		public static void main(String[] args) {
			System.out.println("");
		}
}