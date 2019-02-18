package com.dvdstore.model;

public interface CustomersUtility {
	
	public void add(String email,String password,String nome);
	public Customers find(String email,String password);
	public boolean alreadysub(String email);
	public boolean checkcp(String email,String password);

}
