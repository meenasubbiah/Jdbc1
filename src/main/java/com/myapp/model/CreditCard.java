package com.myapp.model;

public class CreditCard {
	
	private int user_id;
	private String name;
	private int due;
	private int limit;
	private String status;
	

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDue() {
		return due;
	}

	public void setDue(int due) {
		this.due = due;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CreditCard(int user_id, String name, int due, int limit,
			String status) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.due = due;
		this.limit = limit;
		this.status = status;
	}
	@Override
	public String toString() {
		return "CreditCard [user_id=" + user_id + ", name=" + name + ", due="
				+ due + ", limit=" + limit + ", status=" + status + "]";
	}
	

}
