package com.dao;
import com.db.DBHelper;
import com.bean.AdminBean;
import java.util.*;
import java.sql.*;

public class AdviceDao {

	//获取列表
	public List<AdviceBean> GetList(String strwhere,String strorder){
		String sql="select Ono, Oname, Pno, Cno, Ontime, Offtime, Sno, Ostatus from require_info";
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
				cnbean.setCno(rs.getInt("Cno"));
				cnbean.setPno(rs.getInt("Pno"));
				cnbean.setSno(rs.getInt("Sno"));
				cnbean.setOname(rs.getString("Oname"));
				cnbean.setOntime(rs.getDate("Ontime"));
				cnbean.setOfftime(rs.getDate("Offtime"));
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

	public AdviceBean GetBean(final String Oname){
		String sql="select Ono, Oname, Cno, Pno, 
        Ontime, Offtime, Ostatus, Sno from  Advice  
        where Oname="+oname;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		AdviceBean cnbean=new AdviceBean();
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
	public void Update(AdviceBean cnbean){
		String sql="update require_info set ";
		sql+="Ono="+cnbean.getOno()+",";
		sql+="Qname='"+cnbean.getOname()+”’,”;
		sql+="Pno="+cnbean.getPno()+”,”;
		sql+="Cno="+cnbean.getCno()+”,”;
		sql+="Ontime='"+cnbean.getOntime()+”’,”;
		sql+="Offtime='"+cnbean.getOfftime()+”’,”;
		sql+="Sno="+cnbean.getSno()+”,”;
		sql+="Ostatus="+cnbean.getOstatus();	
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

