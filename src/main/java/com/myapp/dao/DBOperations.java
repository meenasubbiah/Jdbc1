package com.myapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBOperations {
	
	private Connection con=null;
	private Statement stmt=null;
	private PreparedStatement prepStmt=null;
	
	
	public DBOperations(Connection con){
		this.con=con;
	}
	public void createTable(){
		try {
			stmt = con.createStatement();
			int result = stmt.executeUpdate("CREATE TABLE Credit_card(user_id INT NOT NULL,name VARCHAR(50) NOT NULL,due INT,limit INT,status varchar(20) default 'Not Set',PRIMARY KEY (user_id));");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
        
	}
	public void insertData(int userid,String name,int due,int limit,String status){
		try{
			prepStmt=con.prepareStatement("INSERT INTO Credit_card VALUES (?,?,?,?,?)");
			//int result = prepStmt.executeUpdate("INSERT INTO Credit_card VALUES (?,?,?,?,?)"); 
			prepStmt.setInt(1,userid);
			prepStmt.setString(2,name); 
			prepStmt.setInt(3,due);
			prepStmt.setInt(4,limit);
			prepStmt.setString(5,status);  
			prepStmt.executeUpdate(); 
		}catch(SQLException e){
			e.printStackTrace();
	}
	}
	public void updateDue(int userid,int due){
		try{
				stmt = con.createStatement();
				stmt.executeUpdate("UPDATE Credit_card SET DUE="+due+"where user_id="+userid);
		}catch(SQLException e){
				e.printStackTrace();
		}
		}	
	public void updateLimit(int limit,int userid){
		try{
			stmt = con.createStatement();
			stmt.executeUpdate("UPDATE Credit_card SET limit="+limit+"where user_id="+userid);
			//stmt.executeUpdate(); 
		}catch(SQLException e){
			e.printStackTrace();
	}	
	}
	public void dropTable(){
		try{
			stmt = con.createStatement();
			int res=stmt.executeUpdate("DROP table credit_card");
		}catch(SQLException e){
		e.printStackTrace();
		}
	}
	public void deleteRecord(int userid){
		try{
			stmt = con.createStatement();
			int res=stmt.executeUpdate("DELETE FROM credit_card WHERE user_id="+userid);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void updateStatus(){
		try{
			int userid=0;
			int due=0;
			int limit=0;
			stmt = con.createStatement();
	        ResultSet result = stmt.executeQuery("SELECT user_id,due,limit FROM Credit_card");
	         
	         while(result.next()){
	        	 userid=result.getInt(1);
	        	 due=result.getInt(2);
	        	 limit=result.getInt(3);
	        	 stmt = con.createStatement();
	        	 if(due>limit){
	        		  stmt.executeUpdate("UPDATE credit_card SET status = 'disabled'  WHERE user_id ="+userid);
	        	 }
	        	 else{
	        		  stmt.executeUpdate("UPDATE credit_card SET status = 'enabled'  WHERE user_id ="+userid);
	         }}
	        	 
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	
		
		

}

