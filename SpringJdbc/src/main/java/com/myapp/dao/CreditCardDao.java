package com.myapp.dao;

import com.myapp.model.CreditCard;

public interface CreditCardDao {
	
	public void createTable();
	
	public int insertData(CreditCard creditCard);
	
	public void getAllCardDetails();
	
	public int updateDue(CreditCard creditCard,int due);
	
	public int updateLimit(CreditCard creditCard,int limit);
	
	public void dropTable();
	
	public int deleteRecord(CreditCard creditCard);
	
	public void updateStatus();
	
	public void loadDatabase(String path);

}
