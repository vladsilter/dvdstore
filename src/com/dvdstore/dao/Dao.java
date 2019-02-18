package com.dvdstore.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//CLASSE SINGLETON PER LA CONNESSIONE AL DB
public class Dao {
	private static Connection conn = null;
	private static DataSource ds=null;
	
	private Dao() {
		
		Context initCtx;
		Context envCtx;
		
		try {
			initCtx = new InitialContext();
			envCtx = (Context) initCtx.lookup("java:comp/env");
			ds = (DataSource)envCtx.lookup("jdbc/provaDB");
		}
		catch(NamingException exc1){
			exc1.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		if(ds==null) {//controllo sul datasource
			new Dao();
		}
		
		try {
			conn=ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
