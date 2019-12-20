package com.dao;
import com.db.DBHelper;
import com.bean.AdminBean;
import java.util.*;
import java.sql.*;

public class ReplenishDao {
	
	//获取列表
	public List<StorageBean> GetList(String strwhere,String strorder){
		String sql="select Pno, Quantity, Pname from storage";
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
		List<StorageBean> list=new ArrayList<StorageBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				StorageBean cnbean=new StorageBean();
				cnbean.setPno(rs.getInt("Pno"));
            	cnbean.setQuantity(rs.getInt("Quantity"));
				cnbean.setPname(rs.getString("Pname"));
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
	
	//修改
	public void Update(StorageBean cnbean){
		String sql="update storage set ";
		sql+="Pno="+cnbean.getPno()+",";
		sql+="Pname='"+cnbean.getPname()+"',";
		sql+="Quantity="+cnbean.getQuantity()+",";
		//sql+="Stockout_Flag="+cnbean.getStockout_Flag();	
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


