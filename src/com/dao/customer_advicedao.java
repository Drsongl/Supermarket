package com.dao;
import com.db.DBHelper;
import com.bean.AdminBean;
import java.util.*;
import java.sql.*;

public class customer_AdviceDao {


		//获取列表
	public List<AdviceBean> GetList(String strwhere,String strorder){
		String sql="select Ono, Oname, Cno, Ontime, Offtime, Ostatus, Sno from  require_info";
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
				AdviceBean cnbean=new AdviceBean();
				cnbean.setOno(rs.getInt("Ono"));
				cnbean.setOname(rs.getString("Oname"));
				cnbean.setCno(rs.getInt("Cno"));
				cnbean.setSno(rs.getInt("Sno"));
				cnbean.setOntime(rs.getDate("Ontime"));
				cnbean.setOfftime(rs.getDate("Offtime"));
				cnbean.setOstatus(rs.getint("Ostatus"));
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