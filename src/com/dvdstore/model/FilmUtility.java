package com.dvdstore.model;

import java.util.ArrayList;

public interface FilmUtility {
	
	public Film getById(int id);
	public ArrayList<Film> getAll();
	public ArrayList<Film> getByTitle(String title);
	public ArrayList<Film> getByCategory(int categoryId);
}