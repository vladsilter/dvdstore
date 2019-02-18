package com.dvdstore.model;

import java.util.ArrayList;

public class Cart {
	private ArrayList<Film> listaFilm;

	public Cart() {
		super();
		listaFilm=new ArrayList();
	}

	public ArrayList<Film> getListaFilm() {
		return listaFilm;
	}

	public void setListaFilm(ArrayList<Film> listaFilm) {
		this.listaFilm = listaFilm;
	}
	
}