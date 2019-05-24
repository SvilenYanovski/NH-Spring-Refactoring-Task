package com.shoestore.repo;

import com.shoestore.domain.Order;

//TODO: Repository needs to be implemented!
public interface OrderRepo {

	Order getOrderByShopperId(long shopperId);

	Order commit(Order order);
	void rollback(Order order);

}
