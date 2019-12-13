package com.db;

import java.sql.*;

public class DBHelper {	
	private String dbClassName = "net.sourceforge.jtds.jdbc.Driver";
	private String dbUrl="jdbc:jtds:sqlserver://localhost:1433/" + "sushe;SelectMethod = Cursor";
	private String dbUser="sa";
	private String dbPassword="123456";
//	private String second=null;
	
	//连接数据库
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
	
//    测试
	public static void main(String[] args)
	{
		System.out.println(new DBHelper().getConn());
	}
	
}
