package com.shoestore.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shoestore.entities.Order;
import com.shoestore.entities.OrderItem;
import com.shoestore.entities.OrderStatus;
import com.shoestore.entities.ShoeInventory;

import static com.shoestore.constants.Constants.*;

@Service
public class ShoeStoreService {

	public long depositPairs(ShoeInventory inventory, int shoeSize, int additionalPairs) {
		if (!inventory.availability.containsKey(shoeSize)) {
			return ERROR_INVALID_SHOE_SIZE;
		} else if (additionalPairs <=0 ) { 
			return ERROR_NEGATIVE_DEPOSIT_AMOUNT;
		} else {
			return inventory.availability.put(shoeSize, inventory.availability.get(shoeSize) + additionalPairs);
		}
	}
	
	public long reservePair(ShoeInventory inventory, int shoeSize) {
		if (!inventory.availability.containsKey(shoeSize)) {
			return ERROR_INVALID_SHOE_SIZE;
		} else if (inventory.availability.get(shoeSize) ==0 ) { 
			return ERROR_OUT_OF_STOCK;
		} else {
			return inventory.availability.put(shoeSize, inventory.availability.get(shoeSize) - 1);
		}
	}
	
	public long bumpVersion(Order order, long currentVersion) {
		if (currentVersion != order.getVersion())
			return ERROR_INCONSISTENT_VERSIONS_HISTORY;
		else {
			order.setVersion(currentVersion + 1);
			return order.getVersion();
		}
	}

    public long addToCart(Order order, OrderItem orderItem) {
    	if (order.getStatus() != OrderStatus.SHOPPING_CART) return ERROR_INVALID_ORDER_STATUS;
		return order.getItems().add(orderItem) ? 0 : -100;
	}

    public long removeFromCart(Order order, OrderItem orderItem) {
    	if (order.getStatus() != OrderStatus.SHOPPING_CART) return ERROR_INVALID_ORDER_STATUS;
		return order.getItems().remove(orderItem) ? 0 : -100;
	}

	public long checkoutOrder(Order order) {
		if (order.getStatus() != OrderStatus.SHOPPING_CART) return ERROR_INVALID_ORDER_STATUS;
		order.setStatus(OrderStatus.CHECKED_OUT);
		return 0;
		//IGNORE: unfinished implementation
	}

	public long shipOrder(Order order) {
		if (order.getStatus() != OrderStatus.CHECKED_OUT) return ERROR_INVALID_ORDER_STATUS;
		order.setStatus(OrderStatus.SHIPPING);
		//IGNORE: unfinished implementation
		return 0;
	}

	public long completeOrder(Order order) {
		if (order.getStatus() != OrderStatus.SHIPPING) return ERROR_INVALID_ORDER_STATUS;
		order.setStatus(OrderStatus.CLOSED);
		//IGNORE: unfinished implementation
		return 0;
	}

	public List<OrderItem> cancelOrder(Order order) {
		if (order.getStatus() != OrderStatus.SHOPPING_CART) return null;
		order.setStatus(OrderStatus.CANCELED);
		//IGNORE: unfinished implementation
		return order.getItems();
	}
}
