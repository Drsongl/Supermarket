package com.dao;
import com.db.DBHelper;
import com.bean.AdminBean;
import java.util.*;
import java.sql.*;
	
public class WorkerDao {

public WorkerBean Getlist(String Sjob){
		String sql="select * from Worker where
		Sjob="+Sjob;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<WorkerBean> list=new ArrayList<WorkerBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setSno(rs.getInt("sno"));
				cnbean.setSjob(rs.getstring("sjob"));
				cnbean.setSname(rs.getstring("sname"));
				cnbean.setSgrade(rs.getint("sgrade"));
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



public WorkerBean Getbean(String Sname){
		String sql="select * from Worker where
		Sname="+Sname;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		WorkerBean cnbean=new WorkerBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setSno(rs.getInt("sno"));
				cnbean.setSjob(rs.getstring("sjob"));
				cnbean.setSname(rs.getstring("sname"));
				cnbean.setSgrade(rs.getint("sgrade"));
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


public WorkerBean Getbean(String Sno){
		String sql="select * from Worker where
		Sno="+Sno;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		WorkerBean cnbean=new WorkerBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setSno(rs.getInt("sno"));
				cnbean.setSjob(rs.getstring("sjob"));
				cnbean.setSname(rs.getstring("sname"));
				cnbean.setSgrade(rs.getint("sgrade"));
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




//修改个人信息
	public void Update(WorkerBean cnbean){
		String sql="update Worker set ";
		sql+="Sjob='"+cnbean.getSjob()+"',";
		sql+="Sgrade='"+cnbean.getSgrade()+"',";
		sql+="Sname='"+cnbean.getSname()+"',";
		sql+="where Sno="+cnbean.getSno();
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
	