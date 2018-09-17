package com.myapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myapp.dao.CreditCardDao;
import com.myapp.dao.CreditCardDaoImpl;
import com.myapp.model.CreditCard;

public class Main {

	public static void main(String[] args) {
		
		 ApplicationContext ctx=new ClassPathXmlApplicationContext("Spring.xml");  
		 
		 
		 CreditCardDao cardDao=(CreditCardDaoImpl)ctx.getBean("dao",CreditCardDaoImpl.class);
		 
		 cardDao.dropTable();
		 
		 cardDao.createTable();
		 
		 //LoadDatabase ld=new LoadDatabase(path, con)
		 
		 CreditCard creditCard=new CreditCard();
		 creditCard.setUserId(1);
		 creditCard.setName("rgrtg");
		 creditCard.setDue(1000);
		 creditCard.setLimit(55455);
		 creditCard.setStatus("null");
		 
		 cardDao.insertData(creditCard);
		 
		 CreditCard creditCard2=new CreditCard();
		 creditCard2.setUserId(2);
		 creditCard2.setName("rgrtg");
		 creditCard2.setDue(1000);
		 creditCard2.setLimit(55455);
		 creditCard2.setStatus("null");
		 
		 cardDao.insertData(creditCard2);
		 
		 cardDao.updateDue(creditCard,123456);
		 
		 cardDao.updateLimit(creditCard,456321);
		 
		// cardDao.deleteRecord(creditCard2);
		 
		 cardDao.loadDatabase("C://Users//meenas//Documents//creditcard.txt");
		 
		 cardDao.updateStatus();
		 
		 cardDao.getAllCardDetails();
		 
	}

}
