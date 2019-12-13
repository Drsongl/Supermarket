package com.dao;
import com.db.DBHelper;
import com.bean.AdminBean;
import java.util.*;
import java.sql.*;

public class ReplenishDao {
	

	public StorageBean GetList(String Pname){
		String sql="select Pno, Pname, Allquantity, 
        from  Storage, Product
        where Product.Pno=Storage.Pno 
        and Pname="+pname;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<ReplenishBean> list=new ArrayList<ReplenishBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setPno(rs.getInt("pno"));
				cnbean.setPname(rs.getstring("pname"));
				cnbean.setAllquantity(rs.getInt("allquantity"));
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
