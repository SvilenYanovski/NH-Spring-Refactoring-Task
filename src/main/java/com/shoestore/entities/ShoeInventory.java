package com.shoestore.entities;

import java.util.HashMap;

public class ShoeInventory {
	private static final int INITIAL_AVAILABILITY = 0;
	private static final int[] SHOE_SIZES = new int[] {
			34, 35, 36, 37, 38, 39,
			40, 41, 42, 43, 44, 45, 46
	};
	
	private Shoe model;
	
	@SuppressWarnings("serial")
	public HashMap<Integer, Integer> availability = new HashMap<Integer, Integer>() {{
		for (int size : SHOE_SIZES) {
			put(size, INITIAL_AVAILABILITY);
		}
	}};
	
	public ShoeInventory(Shoe model) {
		super();
		this.model = model;
	}
	
	public Shoe getModel() {
		return model;
	}
	
}
