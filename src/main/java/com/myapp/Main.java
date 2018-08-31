package com.myapp;

import java.sql.Connection;

import com.myapp.dao.DBOperations;
import com.myapp.dao.LoadDatabase;
import com.myapp.factory.DBConnect;



public class Main {
	
	 public static void main( String[] args ) throws Exception{
	       
		Connection con;
		try {
			con = DBConnect.getConnection();
		}catch (Exception e) {
			
			e.printStackTrace();
			throw e;
		}
		DBOperations dop=new DBOperations(con);
		
		dop.dropTable();
		
		dop.createTable();
		
		LoadDatabase ld=new LoadDatabase("C://Users//meenas//Documents//creditcard.txt",con);
		ld.readFile();
		
		dop.updateStatus();
		
		//dop.deleteRecord(100);
		
		//dop.insertData(userid, name, due, limit, status);
	
		 
	    }
	    
	   
}
