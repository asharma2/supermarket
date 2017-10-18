package com.ubs.supermarket.model;

public class SpecialPrice {

	private int quantity;
	private double price;

	public SpecialPrice() {
	}

	public SpecialPrice(int quantity, double price) {
		super();
		this.quantity = quantity;
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
