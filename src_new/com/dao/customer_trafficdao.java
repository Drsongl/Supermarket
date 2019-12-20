package com.dao;

import com.db.DBHelper;
import com.bean.TrafficBean;
import java.util.*;
import java.sql.*;
//xiaofeijilu
public class customer_trafficdao {

	public List<TrafficBean> GetList(String strwhere,String strorder){
		String sql="select Tno, Ttime,Gno from traffic_info";
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
				TrafficBean cnbean = new TrafficBean();
				cnbean.setTno(rs.getInt("Tno"));
				cnbean.setTtime(rs.getDate("Ttime"));
				cnbean.setGno(rs.getInt("Gno"));
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

