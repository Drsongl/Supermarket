package com.dao;
import com.db.DBHelper;
import com.bean.AdminBean;
import java.util.*;
import java.sql.*;

public class ReplenishDao {
	
	public List<ReplenishBean> GetList(String strwhere,String strorder){
		String sql="select Ino, Proname, Pname, Vno, Lno, Grossprice, Sno, Idate from  replenish, product_info, supplier where product_info.Pno=replenish.Pno and replenish.Prono = supplier.Prono ";
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
		List<ReplenishBean> list=new ArrayList<ReplenishBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setIno(rs.getInt("Ino"));
				cnbean.setProname(rs.getstring("Proname"));
				cnbean.setPname(rs.getString("Pname"));
				cnbean.setVno(rs.getInt("Vno"));
				cnbean.setGrossprice(rs.getInt("Grossprice"));
				cnbean.setLno(rs.getInt("Lno"));
				cnbean.setSno(rs.getInt("Sno"));
				cnbean.setIdate(rs.getDate("Idate"));
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
		String sql="insert into replenish (";
		sql+="Ino,Prono,Pno,Inum,Grossprice,Sno,Idate";
		sql+=") values(";
		sql+=cnbean.getIno()+","+cnbean.getProno()+","+cnbean.getPno()+","+cnbean.getInum()+","+cnbean.getGrossprice()+","+cnbean.getSno()+",'"+cnbean.getIdate()+"'";
		sql+=")";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			rs = stat.executeUpdate(sql);
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
}
	