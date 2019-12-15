package com.dao;

import com.db.DBHelper;
import com.bean.TrafficBean;
import java.util.*;
import java.sql.*;
//xiaofeijilu
public class customer_trafficdao {
	
	//个人消费记录 v

	public TrafficBean GetAllList(final Int Cno){
		final String sql="select Tno, Ttime,Gno from traffic_info where Cno"+Cno;
		Statement stat = null;
		ResultSet rs = null;
		final Connection conn = new DBHelper().getConn();
		final List<TrafficBean> list=new ArrayList<TrafficBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				final TrafficBean cnbean = new TrafficBean();
				cnbean.setTno(rs.getInt("Tno"));
				cnbean.setTtime(rs.getDate("Ttime"));
				cnbean.setGno(rs.getInt("Gno"));
				list.add(cnbean);
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (final SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
    }
	//个人消费记录 chaxun  (日期)

    public TrafficBean GetList1(final Int Cno ,int Gno){
		final String sql="select Tno, Ttime,Gno from traffic_info where Cno='"+Cno+"'and Gno='"+Gno+"'";
		Statement stat = null;
		ResultSet rs = null;
		final Connection conn = new DBHelper().getConn();
		final List<TrafficBean> list=new ArrayList<TrafficBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				final TrafficBean cnbean = new TrafficBean();
				cnbean.setTno(rs.getInt("Tno"));
				cnbean.setTtime(rs.getDate("Ttime"));
				cnbean.setGno(rs.getInt("Gno"));
				list.add(cnbean);
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (final SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
    }
//个人消费记录 chaxun  (日期)

	public TrafficBean GetList2(final Int Cno , Date Ttime){
		final String sql="select Tno, Ttime,Gno from traffic_info where Cno"+Cno+"'and Ttime='"+Ttime+"'";
		Statement stat = null;
		ResultSet rs = null;
		final Connection conn = new DBHelper().getConn();
		final List<TrafficBean> list=new ArrayList<TrafficBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				final TrafficBean cnbean = new TrafficBean();
				cnbean.setTno(rs.getInt("Tno"));
				cnbean.setTtime(rs.getDate("Ttime"));
				cnbean.setGno(rs.getInt("Gno"));
				list.add(cnbean);
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (final SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
    }
    //个人消费记录 chaxun  (pname)

	public TrafficBean GetList(final String Cno ,String Pname){
		final String sql="select Tno, Ttime,Gno from traffic_info where Cno"+Cno;
		Statement stat = null;
		ResultSet rs = null;
		final Connection conn = new DBHelper().getConn();
		final List<TrafficBean> list=new ArrayList<TrafficBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				final TrafficBean cnbean = new TrafficBean();
				cnbean.setTno(rs.getInt("Tno"));
				cnbean.setTtime(rs.getString("Ttime"));
				cnbean.setGno(rs.getString("Gno"));
				list.add(cnbean);
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (final SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
    }
}

