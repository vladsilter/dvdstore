package com.dvdstore.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dvdstore.dao.Dao;

public class CustomersImpl implements CustomersUtility {

	@Override
	public Customers find(String email, String cognome) {
		Customers cs=null;
		//String query="select address_id from sakila.customer where email= '"+email+"'";
		String query2="select*from sakila.customer where email = '"+email+"'";
		Connection c=Dao.getConnection();
		try {
			Statement s = c.createStatement();
			ResultSet rst=s.executeQuery(query2);
			if(rst.first()) {
				cs=new Customers();
				cs.setNome(rst.getString("first_name"));
				//cs.setCognome(rst.getString("last_name"));
				cs.setCognome(rst.getString("last_name"));
			}
			if(!cs.getCognome().contentEquals(cognome)) {
				cs=null;
			}

			
				
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			Dao.closeConnection();
		}
		// TODO Auto-generated method stub
		return cs;
	}

	@Override
	public void add(String email, String password, String nome) {
		// TODO Auto-generated method stub
		String query="insert into sakila.customer (store_id,first_name,last_name,email,address_id) values(1,'"+nome+"','"+password+"','"+email+"',1)";
		System.out.println(query);
		Connection c=Dao.getConnection();
		try {
			System.out.println("tento di eseguire "+query);
			Statement s = c.createStatement();
			s.executeUpdate(query);
			System.out.println("eseguita "+query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			Dao.closeConnection();
		}
		
		
	}

	@Override
	public boolean alreadysub(String email) {
		// TODO Auto-generated method stub
		String query="select*from sakila.customer where email = '"+email+"'";
		Connection c=Dao.getConnection();
		try {
			Statement s = c.createStatement();
			ResultSet rst=s.executeQuery(query);
			if(rst.first()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			Dao.closeConnection();
		}
		return false;
	}

	@Override
	public boolean checkcp(String email, String cognome) {
		// TODO Auto-generated method stub
		Customers cs=null;
		String query="select*from sakila.customer where email = '"+email+"'";
		Connection c=Dao.getConnection();
		try {
			Statement s = c.createStatement();
			ResultSet rst=s.executeQuery(query);
			if(rst.first()) {
				cs=new Customers();
				cs.setNome(rst.getString("first_name"));
				//cs.setCognome(rst.getString("last_name"));
				cs.setCognome(rst.getString("last_name"));
			}
			if(!cs.getCognome().contentEquals(cognome)) {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			Dao.closeConnection();
		}
		return true;
		

	}
	
	
	}

//}
