package com.dao;
import com.db.DBHelper;
import com.bean.*;
import java.util.*;
import java.sql.*;

public class ReplenishDao {
	
	public List<ReplenishBean> GetList(String strwhere,String strorder){
		String sql="select Ino, Proname, Pname, Vname, Lname, Grossprice, Sno, Idate, Inum from  replenish, product_info, producttree, supplier where product_info.Pno=replenish.Pno and replenish.Prono = supplier.Prono and Product_info.Lno=producttree.Lno ";
		if(!(isInvalid(strwhere)))
		{
			sql+=" and "+strwhere;
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
				ReplenishBean cnbean= new ReplenishBean();
				cnbean.setIno(rs.getInt("Ino"));
				cnbean.setProname(rs.getString("Proname"));
				cnbean.setPname(rs.getString("Pname"));
				cnbean.setVname(rs.getString("Vname"));
				cnbean.setLname(rs.getString("Lname"));
				cnbean.setGrossprice(rs.getInt("Grossprice"));
				cnbean.setSno(rs.getInt("Sno"));
				cnbean.setInum(rs.getInt("Inum"));
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
		sql+="Prono,Pno,Inum,Grossprice,Sno,Idate";
		sql+=") values(";
		sql+=cnbean.getProno()+","+cnbean.getPno()+","+cnbean.getInum()+","+cnbean.getGrossprice()+","+cnbean.getSno()+", getdate() ";
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
	//�ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//����
	public static void main(String[] args) {
		System.out.println();
	}
}
	