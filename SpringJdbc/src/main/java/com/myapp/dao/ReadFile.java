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
import java.util.List;

import com.myapp.model.CreditCard;

public class ReadFile {
	
	private String path;
	private ArrayList<CreditCard> creditCard=new ArrayList<>();
	
	public ReadFile(String path){
		this.path = path;
		
	}
	
	public List<CreditCard> readFile(){
		
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
					creditCard.add(new CreditCard(Integer.parseInt(cardDetail[0]), cardDetail[1], Integer.parseInt(cardDetail[2]), Integer.parseInt(cardDetail[3]), cardDetail[4]));
					line=br.readLine();
				}
				
				
			} catch (IOException e){
				e.printStackTrace();
			}finally{
				if(br!=null){
					try{
				br.close();
				is.close();
				fis.close();
					}catch(IOException e){
						e.printStackTrace();
						throw new RuntimeException();
					}
				}
			}
			
			return creditCard;
				
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
}
