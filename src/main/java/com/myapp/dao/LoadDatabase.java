package com.myapp.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.myapp.model.CreditCard;

public class LoadDatabase {
	
	private String path;
	private Connection con=null;
	private ArrayList<CreditCard> creditCard=new ArrayList<>();
	
	public LoadDatabase(String path,Connection con){
		this.path = path;
		this.con=con;
	}
	
	public void readFile(){
		
		FileInputStream fis=null;
		InputStreamReader is=null;
		BufferedReader br=null;
		
		
		try{
			
			fis=new FileInputStream(path);
			is=new InputStreamReader(fis);
			br=new BufferedReader(is);
			
			String line=null;
			
			String[] cardDetail=null;
			
			try {
				line=br.readLine();
				
				while(line!=null){
					cardDetail=line.split(",");
					line=br.readLine();
					creditCard.add(new CreditCard(Integer.parseInt(cardDetail[0]), cardDetail[1], Integer.parseInt(cardDetail[2]), Integer.parseInt(cardDetail[3]), cardDetail[4]));
				}
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
				
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		System.out.println("details:");
		for(CreditCard card:creditCard){
			System.out.println(card);
		}
		loadDatabase();
	}
	
	private void loadDatabase(){
		try {
			PreparedStatement prepStmt=con.prepareStatement("INSERT INTO Credit_card VALUES (?,?,?,?,?)");
			System.out.println(creditCard.get(0).getUser_id());
			for(CreditCard card:creditCard){
				prepStmt.setInt(1,card.getUser_id());
				System.out.println(card.getUser_id());
				prepStmt.setString(2,card.getName()); 
				prepStmt.setInt(3,card.getDue());
				prepStmt.setInt(4,card.getLimit());
				prepStmt.setString(5,card.getStatus());
				
				//prepStmt.executeUpdate();
				prepStmt.addBatch();
			}
			prepStmt.executeBatch();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
