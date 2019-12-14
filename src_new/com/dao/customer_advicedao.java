package com.dao;
import com.db.DBHelper;
import com.bean.AdminBean;
import java.util.*;
import java.sql.*;

public class customer_AdviceDao {

    //모든건의,건의검색결과,이전건의,건의하기
    //모든건의获取所有列表
    public AdviceBean GetList(final Int ostatus){
		String sql="select Ono, Oname, Cno, Pno, 
        Ontime, Offtime, Ostatus, Sno from  Advice  
        where Ostatus="+ostatus;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<AdviceBean> list=new ArrayList<AdviceBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setOno(rs.getInt("ono"));
				cnbean.setOname(rs.getstring("oname"));
				cnbean.setCno(rs.getInt("cno"));
				cnbean.setPno(rs.getInt("pno"));
				cnbean.setOntime(rs.getDate("ontime"));
				cnbean.setOfftime(rs.getDate("offtime"));
				cnbean.setOstatus(rs.int("ostatus"));
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
    
    //건의검색결과 建议查询
    public AdviceBean GetList(final Int ostatus){
		String sql="select Ono, Oname, Cno, Pno, 
        Ontime, Offtime, Ostatus, Sno from  Advice  
        where Ostatus="+ostatus;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<AdviceBean> list=new ArrayList<AdviceBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setOno(rs.getInt("ono"));
				cnbean.setOname(rs.getstring("oname"));
				cnbean.setCno(rs.getInt("cno"));
				cnbean.setPno(rs.getInt("pno"));
				cnbean.setOntime(rs.getDate("ontime"));
				cnbean.setOfftime(rs.getDate("offtime"));
				cnbean.setOstatus(rs.int("ostatus"));
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
    //이전건의 Cno=顾客编号

    //건의하기
}