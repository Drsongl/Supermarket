package com.db;

import java.sql.*;

public class DBHelper {	
	private String dbClassName = "net.sourceforge.jtds.jdbc.Driver";
	private String dbUrl="jdbc:jtds:sqlserver://localhost:1433/" + "supermarket;SelectMethod = Cursor";
	private String dbUser="sa";
	private String dbPassword="123456";
//	private String second=null;
	
	//�������ݿ�
	public Connection getConn(){
		Connection conn = null;
		try{
			Class.forName(dbClassName);
		}
		catch(Exception e){}
		try{
			conn=DriverManager.getConnection(dbUrl,dbUser,dbPassword);
		}
		catch(SQLException ex){}
		return conn;		
	}
	
//    ����
	public static void main(String[] args)
	{
		System.out.println(new DBHelper().getConn());
	}
	
}
