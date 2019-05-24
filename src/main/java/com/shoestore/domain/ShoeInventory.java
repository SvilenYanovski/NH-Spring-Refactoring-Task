package com.shoestore.domain;

import java.util.HashMap;

public class ShoeInventory {
	public static final long ERROR_OUT_OF_STOCK = -1;
	public static final long ERROR_INVALID_SHOE_SIZE = -2;
	public static final long ERROR_NEGATIVE_DEPOSIT_AMOUNT = -1;
	
	private static final int INITIAL_AVAILABILITY = 0;
	private static final int[] SHOE_SIZES = new int[] { 
			34, 35, 36, 37, 38, 39, 
			40, 41, 42, 43, 44, 45, 46 
			};
	
	private ShoeModel model;
	
	@SuppressWarnings("serial")
	public HashMap<Integer, Integer> availability = new HashMap<Integer, Integer>() {{
		for (int size : SHOE_SIZES) {
			put(size, INITIAL_AVAILABILITY);
		}
	}};
	
	public ShoeInventory(ShoeModel model) {
		super();
		this.model = model;
	}
	
	public ShoeModel getModel() {
		return model;
	}
	
}
