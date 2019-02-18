package com.dvdstore.model;

public interface CartUtility {
	public double getTotalPrice(Cart c);
	public void addToCart(Cart c,Film f);
	public void removeFromCart(Cart c,Film f);
	public void emptyCart(Cart c);
	public void confirm(Cart c);
}