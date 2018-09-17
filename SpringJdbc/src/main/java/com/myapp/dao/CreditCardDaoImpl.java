package com.myapp.dao;



import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

import com.myapp.model.CreditCard;


public class CreditCardDaoImpl implements CreditCardDao{
	
	
	private JdbcTemplate jdbcTemplate;
	String sql;
	int res=0;
	
	
	
	

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate=new JdbcTemplate(dataSource);
	}
	
	
	public void createTable(){
		
			sql="CREATE TABLE Credit_card(user_id INT NOT NULL,name VARCHAR(50) NOT NULL,due INT,limit INT,status varchar(20),PRIMARY KEY (user_id))";
			jdbcTemplate.execute(sql);
	}
	public int insertData(CreditCard creditCard){
		
		sql="INSERT INTO Credit_card VALUES (?,?,?,?,?)";
		return jdbcTemplate.update(sql,new Object[]{creditCard.getUserId(),creditCard.getName(),creditCard.getDue(),creditCard.getLimit(),creditCard.getStatus()});
		
		
		
	}
	public int updateDue(CreditCard creditCard,int due){
		sql="UPDATE Credit_card SET DUE=?where user_id=?";
		return jdbcTemplate.update(sql,new Object[]{due,creditCard.getUserId()});
				
		
	}	
	public int updateLimit(CreditCard creditCard,int limit){
		sql="UPDATE Credit_card SET limit=?where user_id=?";
		return jdbcTemplate.update(sql,new Object[]{limit,creditCard.getUserId()});
		
	}
	public void dropTable(){
		
			sql="DROP table credit_card";
			jdbcTemplate.execute(sql);
	
	}
	public int deleteRecord(CreditCard creditCard){
		sql="DELETE FROM credit_card WHERE user_id=?";
		return jdbcTemplate.update(sql,new Object[]{creditCard.getUserId()});
	
	}
	public void loadDatabase(String path){
		
		List<CreditCard> creditCards=new ArrayList<>();
		creditCards=new ReadFile(path).readFile();
		sql="INSERT INTO Credit_card VALUES (?,?,?,?,?)";
		for(CreditCard card:creditCards){
			jdbcTemplate.update(sql,new Object[]{card.getUserId(),card.getName(),card.getDue(),card.getLimit(),card.getStatus()});
		}
		
	}
	public void updateStatus(){
		String sqlForUpdate=null,sqlForSelect=null;
		List<CreditCard> creditCards=new ArrayList<>();
		
		sqlForSelect="SELECT * FROM Credit_card";
		sqlForUpdate="UPDATE credit_card SET status =? WHERE user_id =?";
		
		creditCards=jdbcTemplate.query(sqlForSelect,ParameterizedBeanPropertyRowMapper.newInstance(CreditCard.class));
		for(CreditCard card:creditCards){
			if(card.getDue()>card.getLimit())
				jdbcTemplate.update(sqlForUpdate,new Object[]{"disabled",card.getUserId()});
			else
				jdbcTemplate.update(sqlForUpdate,new Object[]{"enabled",card.getUserId()});
		}         
	}
	@Override
	public void getAllCardDetails() {
		
		sql="SELECT * FROM Credit_card";
		List<CreditCard> creditCards=new ArrayList<>();
		
		creditCards=jdbcTemplate.query(sql,ParameterizedBeanPropertyRowMapper.newInstance(CreditCard.class));
		
		for(CreditCard card:creditCards){
			System.out.println(card);
		}
		
	}	
	

}

