package com.shoestore.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {
	public static final long ERROR_INVALID_ORDER_STATUS = -1;
	public static final long ERROR_INCONSISTENT_VERSIONS_HISTORY = -2;
	
	private Shopper shopper;
	public List<OrderItem> items;
	public OrderStatus status;
	public long version = 0l;
	public Double price = null;
	
	public Order(Shopper shopper) {
		super();
		this.shopper = shopper;
		this.status = OrderStatus.SHOPPING_CART;
		this.items = new ArrayList<OrderItem>();
	}
	
	public Shopper getShopper() {
		return shopper;
	}
	
}
