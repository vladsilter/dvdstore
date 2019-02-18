package com.dvdstore.model;

public class Customers {
	private String addressId;
	private String nome;
	private String cognome;
	private String email;
	public Customers() {
		super();
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String andressid) {
		this.addressId = andressid;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
