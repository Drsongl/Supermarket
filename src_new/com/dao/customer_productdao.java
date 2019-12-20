package com.dao;

import com.db.DBHelper;
import com.bean.AdminBean;
import java.util.*;
import java.sql.*;

public class customer_ProductDao {

    //获取所有列表
  
	public List<ProductBean> GetList(String strwhere,String strorder){
		String sql="select Pno,Pname,Sellprice,Shelfno,Shelfloc from product_info,shelf where product_info.Shelfno=shelf.Shelfno";
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
		List<AdviceBean> list=new ArrayList<AdviceBean>();
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
}



