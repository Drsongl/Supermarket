package com.dao;
import com.db.DBHelper;
import com.bean.AdminBean;
import java.util.*;
import java.sql.*;
	
public class WorkerDao {

	//获取列表
	public List<WorkerBean> GetList(String strwhere,String strorder){
		String sql="select Sno, Sname, Sgrade, Sjob from worker_info";
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
		List<WorkerBean> list=new ArrayList<WorkerBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				WorkerBean cnbean=new WorkerBean();
				cnbean.setSno(rs.getInt("Sno"));
				cnbean.setSno(rs.getInt("Sgrade"));
				cnbean.setSjob(rs.getString("Sjob"));
				cnbean.setSname(rs.getString("Sname"));
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
	
	public WorkerBean Getlist1(String Sjob){
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



	public WorkerBean Getbean1(String Sname){
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


	public WorkerBean Getbean2(int Sno){
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

	//获取指定Sgrade的实体Bean
	public WorkerBean GetList2(int Sgrade){
		String sql="select Sno, Sname, Sgrade, Sjob from worker_info and Sgrade="+Sgrade;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		BuildingBean cnbean=new WorkerBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setSno(rs.getInt("Sno"));
				cnbean.setSno(rs.getInt("Sgrade"));
				cnbean.setSjob(rs.getString("Sjob"));
				cnbean.setSname(rs.getString("Sname"));
				
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
		sql+="Sgrade="+cnbean.getSgrade()+",";
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

	//经理修改员工信息
	public void Update(WorkerBean cnbean){
		String sql="update worker_info set ";
		sql+="Sno="+cnbean.getSno()+",";
		sql+="Sname='"+cnbean.getSname()+"',";
		sql+="Sgrade="+cnbean.getSgrade()+”,”;
		sql+="Sjob='"+cnbean.getSjob()+"'";
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

	//删除
	public void Delete(String strwhere){
		String sql="delete worker_info where ";
		sql += strwhere;
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



	