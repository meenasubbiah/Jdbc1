package com.myapp.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	private static DBConnect dbcon=null;
	private int flag=0;
	private static Connection con=null;
	
	
	private DBConnect() throws Exception{
		try{
				Class.forName("org.hsqldb.jdbc.JDBCDriver");
				System.out.println("Driver loaded");
				con=DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/meenadb", "SA", "");
				System.out.println("Connected to db");
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
			throw e;
	}}
	
	public static Connection getConnection() throws Exception{
		if(dbcon==null){
			dbcon=new DBConnect();
		}
		return con;
	}	

}
