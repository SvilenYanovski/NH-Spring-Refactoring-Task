package com.shoestore.domain;

public class ShoePair extends OrderItem {
	private ShoeModel model;
	private int shoeSize;
	
	public ShoePair(ShoeModel model, int size) {
		this.model = model;
		this.shoeSize = size;
	}
	
	public ShoeModel getModel() {
		return model;
	}

	public int getShoeSize() {
		return shoeSize;
	}
	
}
