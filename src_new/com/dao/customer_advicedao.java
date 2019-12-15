package com.dao;
import com.db.DBHelper;
import com.bean.AdminBean;
import java.util.*;
import java.sql.*;

public class customer_AdviceDao {

    //모든건의,건의검색결과,이전건의,건의하기
    //모든건의获取所有列表v
    public AdviceBean GetAllList(final Int Cno){
		final String sql="select Ono, Oname, Cno, Ontime, Offtime, Ostatus, Sno from  Advice ";
		Statement stat = null;
		ResultSet rs = null;
		final Connection conn = new DBHelper().getConn();
		final List<AdviceBean> list=new ArrayList<AdviceBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setOno(rs.getInt("ono"));
				cnbean.setOname(rs.getString("oname"));
				cnbean.setCno(rs.getInt("cno"));
				cnbean.setOntime(rs.getDate("ontime"));
				cnbean.setOfftime(rs.getDate("offtime"));
				cnbean.setOstatus(rs.int("ostatus"));
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

	// 건의검색결과 建议查询(用户名)v
	public AdviceBean GetList(final Int Cno){
		final String sql="select Ono, Oname, Cno, Ontime, Offtime, Ostatus, Sno from  Advice where Cno="+Cno;
		Statement stat = null;
		ResultSet rs = null;
		final Connection conn = new DBHelper().getConn();
		final List<AdviceBean> list=new ArrayList<AdviceBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setOno(rs.getInt("ono"));
				cnbean.setOname(rs.getString("oname"));
				cnbean.setCno(rs.getInt("cno"));
				cnbean.setPno(rs.getInt("pno"));
				cnbean.setOntime(rs.getDate("ontime"));
				cnbean.setOfftime(rs.getDate("offtime"));
				cnbean.setOstatus(rs.int("ostatus"));
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

	// 건의검색결과 建议查询(time)v
	public AdviceBean GetList(final Int Ontime){
			final String sql="select Ono, Oname, Cno, Ontime, Offtime, Ostatus, Sno from  Advice where Ontime="+Ontime;
			Statement stat = null;
			ResultSet rs = null;
			final Connection conn = new DBHelper().getConn();
			final List<AdviceBean> list=new ArrayList<AdviceBean>();
			try{
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);
				while(rs.next()){
					cnbean.setOno(rs.getInt("ono"));
					cnbean.setOname(rs.getString("oname"));
					cnbean.setCno(rs.getInt("cno"));
					cnbean.setPno(rs.getInt("pno"));
					cnbean.setOntime(rs.getDate("ontime"));
					cnbean.setOfftime(rs.getDate("offtime"));
					cnbean.setOstatus(rs.int("ostatus"));
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
	// 이전건의 以前的建议 Cno=自己的顾客编号 x

	public AdviceBean GetList(final Int Cno){
		final String sql="select Ono, Oname, Cno, Ontime, Offtime, Ostatus, Sno from  Advice where Cno="+Cno;
		Statement stat = null;
		ResultSet rs = null;
		final Connection conn = new DBHelper().getConn();
		final List<AdviceBean> list=new ArrayList<AdviceBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setOno(rs.getInt("ono"));
				cnbean.setOname(rs.getString("oname"));
				cnbean.setCno(rs.getInt("cno"));
				cnbean.setPno(rs.getInt("pno"));
				cnbean.setOntime(rs.getDate("ontime"));
				cnbean.setOfftime(rs.getDate("offtime"));
				cnbean.setOstatus(rs.int("ostatus"));
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
    //건의하기 zuojianyi
}