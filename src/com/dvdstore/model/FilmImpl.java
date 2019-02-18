package com.dvdstore.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dvdstore.dao.Dao;

public class FilmImpl implements FilmUtility {

	@Override
	public Film getById(int id) {
		Film f=null;
		
		String query="select *,count(*) as disp from film f inner join film_category c " + 
				"ON f.film_id=c.film_id inner join inventory e ON f.film_id=e.film_id group by e.film_id having e.film_id="+id+";"; 
		Connection c=Dao.getConnection();
		
		try {
			Statement s=c.createStatement();
			ResultSet rst=s.executeQuery(query); //Se non trova niente riceve comunque un Object vuoto
			
			if(rst.first()) {
				f=new Film();
				f.setId(rst.getInt("film_id"));
				f.setTitle(rst.getString("title"));
				f.setDescription(rst.getString("description"));
				f.setLength(rst.getInt("length"));
				f.setPrice(rst.getDouble("replacement_cost"));
				f.setCategoryId(rst.getInt("category_id"));
				f.setDisp(rst.getInt("disp"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			Dao.closeConnection();
		}
		return f;
	
	}

	@Override
	public ArrayList<Film> getAll() {
		Film f;
		ArrayList<Film> lista=new ArrayList<Film>();
		Connection c=Dao.getConnection();
		
		try {
			Statement s=c.createStatement();
			String query="select *,count(*) as disp from film f inner join film_category c " + 
					"ON f.film_id=c.film_id inner join inventory e ON f.film_id=e.film_id group by e.film_id;";	
			ResultSet rst=s.executeQuery(query); 
			
			while(rst.next()) {
				f=new Film();
				f.setId(rst.getInt("film_id"));
				f.setTitle(rst.getString("title"));
				f.setDescription(rst.getString("description"));
				f.setLength(rst.getInt("length"));
				f.setPrice(rst.getDouble("replacement_cost"));
				f.setCategoryId(rst.getInt("category_id"));
				f.setDisp(rst.getInt("disp"));
				lista.add(f);
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
	public ArrayList<Film> getByTitle(String title) {
		Film f;
		ArrayList<Film> lista=new ArrayList<Film>();
		Connection c=Dao.getConnection();
		
		try {
			Statement s=c.createStatement();
			String query=
					"SELECT *,count(*) as disp FROM film f inner join film_category c " + 
					"ON c.film_id=f.film_id "
							+ "inner join inventory e ON f.film_id=e.film_id and f.title LIKE '%"+title+"%'"
							+ " group by e.film_id";
			ResultSet rst=s.executeQuery(query); 
			
			while(rst.next()) {
				f=new Film();
				f.setId(rst.getInt("film_id"));
				f.setTitle(rst.getString("title"));
				f.setDescription(rst.getString("description"));
				f.setLength(rst.getInt("length"));
				f.setPrice(rst.getDouble("replacement_cost"));
				f.setCategoryId(rst.getInt("category_id"));
				f.setDisp(rst.getInt("disp"));
				lista.add(f);
				System.out.println(lista.size());
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
	public ArrayList<Film> getByCategory(int categoryId) {
		Film f;
		ArrayList<Film> lista=new ArrayList<Film>();
		Connection c=Dao.getConnection();
		
		try {
			Statement s=c.createStatement();
			String query="select *,count(*) as disp from film f "
					+ "INNER JOIN film_category c"
					+ " ON f.film_id=c.film_id INNER JOIN inventory e"
					+ " ON f.film_id=e.film_id and c.category_id ="+categoryId
					+ " group by e.film_id";
			ResultSet rst=s.executeQuery(query); 
			
			while(rst.next()) {
				f=new Film();
				f.setId(rst.getInt("film_id"));
				f.setTitle(rst.getString("title"));
				f.setDescription(rst.getString("description"));
				f.setLength(rst.getInt("length"));
				f.setPrice(rst.getDouble("replacement_cost"));
				f.setCategoryId(rst.getInt("category_id"));
				f.setDisp(rst.getInt("disp"));
				lista.add(f);
				System.out.println(lista.size());
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

}/*package com.dvdstore.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dvdstore.dao.Dao;

public class FilmImpl implements FilmUtility {

	@Override
	public Film getById(int id) {
		Film f=null;
		
		String query="select * from film f,film_category c where f.film_id="+id; 
		Connection c=Dao.getConnection();
		
		try {
			Statement s=c.createStatement();
			ResultSet rst=s.executeQuery(query); //Se non trova niente riceve comunque un Object vuoto
			
			if(rst.first()) {
				f=new Film();
				f.setId(rst.getInt("film_id"));
				f.setTitle(rst.getString("title"));
				f.setDescription(rst.getString("description"));
				f.setLength(rst.getInt("length"));
				f.setPrice(rst.getDouble("replacement_cost"));
				f.setCategoryId(rst.getInt("category_id"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			Dao.closeConnection();
		}
		return f;
	
	}

	@Override
	public ArrayList<Film> getAll() {
		Film f;
		ArrayList<Film> lista=new ArrayList<Film>();
		Connection c=Dao.getConnection();
		
		try {
			Statement s=c.createStatement();
			String query="select * from film f "
					+ "INNER JOIN film_category c"
					+ " ON c.film_id = f.film_id;";
					
			ResultSet rst=s.executeQuery(query); 
			
			while(rst.next()) {
				f=new Film();
				f.setId(rst.getInt("film_id"));
				f.setTitle(rst.getString("title"));
				f.setDescription(rst.getString("description"));
				f.setLength(rst.getInt("length"));
				f.setPrice(rst.getDouble("replacement_cost"));
				f.setCategoryId(rst.getInt("category_id"));
				lista.add(f);
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
	public ArrayList<Film> getByTitle(String title) {
		Film f;
		ArrayList<Film> lista=new ArrayList<Film>();
		Connection c=Dao.getConnection();
		
		try {
			Statement s=c.createStatement();
			String query="SELECT * FROM sakila.film f, sakila.film_category c\r\n" + 
					"where f.title LIKE \""+"%"+title+"%"+"\" and c.film_id=f.film_id;";
			ResultSet rst=s.executeQuery(query); 
			
			while(rst.next()) {
				f=new Film();
				f.setId(rst.getInt("film_id"));
				f.setTitle(rst.getString("title"));
				f.setDescription(rst.getString("description"));
				f.setLength(rst.getInt("length"));
				f.setPrice(rst.getDouble("replacement_cost"));
				f.setCategoryId(rst.getInt("category_id"));
				lista.add(f);
				System.out.println(lista.size());
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
	public ArrayList<Film> getByCategory(int categoryId) {
		Film f;
		ArrayList<Film> lista=new ArrayList<Film>();
		Connection c=Dao.getConnection();
		
		try {
			Statement s=c.createStatement();
			String query="select * from film f "
					+ "INNER JOIN film_category c"
					+ " ON c.category_id =" +categoryId
					+ " and c.film_id = f.film_id";
			ResultSet rst=s.executeQuery(query); 
			
			while(rst.next()) {
				f=new Film();
				f.setId(rst.getInt("film_id"));
				f.setTitle(rst.getString("title"));
				f.setDescription(rst.getString("description"));
				f.setLength(rst.getInt("length"));
				f.setPrice(rst.getDouble("replacement_cost"));
				f.setCategoryId(rst.getInt("category_id"));
				lista.add(f);
				System.out.println(lista.size());
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
*/