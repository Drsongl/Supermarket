package com.dao;
import com.db.DBHelper;
import com.bean.*;
import java.util.*;
import java.sql.*;
	
public class SaleDao {

	//获取列表
	public List<TrafficBean> GetList(String strwhere,String strorder){
		String sql="select * from traffic_info, product_info, producttree where traffic_info.Pno=product_info.Pno and producttree.Lno=product_info.Lno ";
		if(!(isInvalid(strwhere)))
		{
			sql+= " and "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+=" order by "+strorder;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<TrafficBean> list=new ArrayList<TrafficBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				TrafficBean cnbean=new TrafficBean();
				
				cnbean.setTno(rs.getInt("Tno"));
				cnbean.setGno(rs.getInt("Gno"));
				cnbean.setTtime(rs.getDate("Ttime"));
				cnbean.setPname(rs.getString("Pname"));
				cnbean.setVname(rs.getString("Vname"));
				cnbean.setLname(rs.getString("Lname"));
				cnbean.setSno(rs.getInt("Sno"));
				cnbean.setCno(rs.getInt("Cno"));
				
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

	public WorkerBean GetBean(int Sno){
		String sql="select * from worker_info where Sno="+Sno ;
		
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		WorkerBean cnbean=new WorkerBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()) {
			cnbean.setSno(rs.getInt("Sno"));
			cnbean.setSgrade(rs.getInt("Sgrade"));
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
	
	public void Add(WorkerBean cnbean){
		String sql="insert into worker_info (";
		sql+="Sno, Sjob, Sgrade, Sname";
		sql+=") values(";
		sql+=cnbean.getSno()+", '"+cnbean.getSjob()+"', "+cnbean.getSgrade()+", '"+cnbean.getSname()+"' ";
		sql+=")";
		
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


//修改个人信息
	public void Update(WorkerBean cnbean){
		String sql="update worker_info set ";
		sql+="Sjob='"+cnbean.getSjob()+"',";
		sql+="Sgrade="+cnbean.getSgrade()+",";
		sql+="Sname='"+cnbean.getSname()+"' ";
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



	