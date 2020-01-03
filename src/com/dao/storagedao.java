package com.dao;
import com.db.DBHelper;
import com.bean.*;
import java.util.*;
import java.sql.*;

public class StorageDao {
	
	//获取列表
	public List<StorageBean> GetList(String strwhere,String strorder){
		String sql="select Storage.Pno Pno, Quantity, product_info.Pname Pname, product_info.Stockout_n Stockout_n from storage, product_info where product_info.Pno=storage.Pno ";
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
		List<StorageBean> list=new ArrayList<StorageBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				StorageBean cnbean=new StorageBean();
				cnbean.setPno(rs.getInt("Pno"));
            	cnbean.setQuantity(rs.getInt("Quantity"));
				cnbean.setPname(rs.getString("Pname"));
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
	
	public StorageBean GetBean(int Pno){
		String sql="select storage.Pno Pno, Quantity, storage.Pname Pname, product_info.Stockout_n Stockout_n from storage, product_info where storage.Pno=product_info.Pno and storage.Pno="+Pno;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		StorageBean cnbean=new StorageBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()) {
			cnbean.setPno(rs.getInt("Pno"));
			cnbean.setQuantity(rs.getInt("Quantity"));
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

	
	//修改
	public void Update(StorageBean cnbean){
		String sql="update storage set ";
		sql+="Quantity="+cnbean.getQuantity()+" ";
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
	
	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//测试
	public static void main(String[] args) {
		System.out.println("");
	}

	
	
}


