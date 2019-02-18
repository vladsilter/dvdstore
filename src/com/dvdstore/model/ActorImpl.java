package com.dvdstore.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dvdstore.dao.Dao;

public class ActorImpl implements ActorUtility {

	@Override
	public Actor findById(int id) {
		Actor ac=null;
		
		String query="select * from actor where actor_id="+id;
		Connection c=Dao.getConnection();
		
		try {
			Statement s=c.createStatement();
			ResultSet rst=s.executeQuery(query); //Se non trova niente riceve comunque un Object vuoto
			
			if(rst.first()) {
				ac=new Actor();
				ac.setNome(rst.getString("first_name"));
				ac.setCognome(rst.getString("last_name"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			Dao.closeConnection();
		}
		return ac;
	}

	@Override
	public ArrayList<Actor> getAll() {
		Actor ac;
		ArrayList<Actor> lista=new ArrayList<Actor>();
		Connection c=Dao.getConnection();
		
		try {
			Statement s=c.createStatement();
			String query="select * from actor";
			ResultSet rst=s.executeQuery(query); 
			
			while(rst.next()) {
				ac=new Actor();
				ac.setNome(rst.getString("first_name"));
				ac.setCognome(rst.getString("last_name"));
				lista.add(ac);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			Dao.closeConnection();
		}
		return lista;
	}

	@Override
	public ArrayList<Actor> findByName(String name) {
		Actor ac=null;
		ArrayList<Actor> lista= new ArrayList<Actor>();
		String query="SELECT * FROM sakila.actor "
				+"where concat(first_name,' ',last_name) LIKE \""+"%"+name+"%"+"\""
				+"or concat(last_name,' ',first_name) LIKE \""+"%"+name+"%"+"\";";
		Connection c=Dao.getConnection();
		
		try {
			Statement s=c.createStatement();
			ResultSet rst=s.executeQuery(query);
			
			while(rst.next()) {
				ac=new Actor();
				ac.setNome(rst.getString("first_name"));
				ac.setCognome(rst.getString("last_name"));
				lista.add(ac);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			Dao.closeConnection();
		}
		return lista;
	}

}
