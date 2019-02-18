package com.dvdstore.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dvdstore.dao.Dao;

public class CartImpl implements CartUtility{

	@Override
	public double getTotalPrice(Cart c) {
		double result=0.0;
		for(Film f:c.getListaFilm()) {
			result=result+f.getPrice();
		}
		return result;
	}

	@Override
	public void addToCart(Cart c, Film f) {
		ArrayList<Film> listaF = c.getListaFilm();
		listaF.add(f);
		c.setListaFilm(listaF);
	}

	@Override
	public void removeFromCart(Cart c, Film f) {
		ArrayList<Film> listaF = c.getListaFilm();
		listaF.remove(f);
		c.setListaFilm(listaF);
	}


	@Override
	public void emptyCart(Cart c) {
		ArrayList<Film> newList=new ArrayList<Film>();
		c.setListaFilm(newList);
	}

	@Override
	public void confirm(Cart c) {
		for(Film f:c.getListaFilm()) {
			int filmid=f.getId();
			int invid=0;
			Connection conn=Dao.getConnection();
			try {
				Statement s=conn.createStatement();
				String query="select i.inventory_id from sakila.inventory i where film_id="+filmid+
						" and i.inventory_id<= all(select i2.inventory_id from sakila.inventory i2 where i2.film_id=i.film_id)";
				ResultSet rst=s.executeQuery(query);
				while(rst.next()) {
					invid=rst.getInt("inventory_id");
					System.out.println("TROVA "+invid);
				}
				String query2="delete from sakila.rental where inventory_id="+invid;
				String query3="delete from sakila.inventory where film_id="+filmid 
						+" and inventory_id="+invid;
				s.executeUpdate(query2);s.executeUpdate(query3);
				
				this.emptyCart(c);
				System.out.println(invid);
				
				
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				Dao.closeConnection();
			}
		}
	}
	
	

}