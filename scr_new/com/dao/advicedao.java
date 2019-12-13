package com.dao;
import com.db.DBHelper;
import com.bean.AdminBean;
import java.util.*;
import java.sql.*;

public class AdviceDao {
public AdviceBean GetList(Int ostatus){
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
public AdviceBean GetList(Date Ontime){
		String sql="select Ono, Oname, Cno, Pno, 
        Ontime, Offtime, Ostatus, Sno from  Advice  
        where Ontime="+ontime;
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
public AdviceBean GetList(Date Offtime){
		String sql="select Ono, Oname, Cno, Pno, 
        Ontime, Offtime, Ostatus, Sno from  Advice  
        where Offtime="+offtime;
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
	public AdviceBean GetBean(String Oname){
		String sql="select Ono, Oname, Cno, Pno, 
        Ontime, Offtime, Ostatus, Sno from  Advice  
        where Oname="+oname;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		AdviceBean cnbean=new AdviceBean();
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