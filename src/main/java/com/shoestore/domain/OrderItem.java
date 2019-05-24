package com.shoestore.domain;

public abstract class OrderItem {
	private long id;
	
	@Override
	public int hashCode() {
		return 7;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		OrderItem other = (OrderItem) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
