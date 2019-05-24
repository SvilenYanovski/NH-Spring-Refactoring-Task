package com.shoestore.entities;

public class ShoePair extends OrderItem {
	private Shoe model;
	private int shoeSize;
	
	public ShoePair(Shoe model, int size) {
		this.model = model;
		this.shoeSize = size;
	}
	
	public Shoe getModel() {
		return model;
	}

	public int getShoeSize() {
		return shoeSize;
	}
	
}
