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
	
//	public long bumpVersion(Order order, long currentVersion) {
//		if (currentVersion != order.version)
//			return ERROR_INCONSISTENT_VERSIONS_HISTORY;
//		else {
//			order.getVersion() = currentVersion + 1;
//			return order.version;
//		}
//	}
//
//    public long addToCart(Order order, OrderItem orderItem) {
//    	if (order.status != OrderStatus.SHOPPING_CART) return Order.ERROR_INVALID_ORDER_STATUS;
//		return order.items.add(orderItem) ? 0 : -100;
//	}
//
//    public long removeFromCart(Order order, OrderItem orderItem) {
//    	if (order.status != OrderStatus.SHOPPING_CART) return Order.ERROR_INVALID_ORDER_STATUS;
//		return order.items.remove(orderItem) ? 0 : -100;
//	}
//
//	public long checkoutOrder(Order order) {
//		if (order.status != OrderStatus.SHOPPING_CART) return Order.ERROR_INVALID_ORDER_STATUS;
//		order.status = OrderStatus.CHECKED_OUT;
//		return 0;
//		//IGNORE: unfinished implementation
//	}
//
//	public long shipOrder(Order order) {
//		if (order.status != OrderStatus.CHECKED_OUT) return Order.ERROR_INVALID_ORDER_STATUS;
//		order.status = OrderStatus.SHIPPING;
//		//IGNORE: unfinished implementation
//		return 0;
//	}
//
//	public long completeOrder(Order order) {
//		if (order.status != OrderStatus.SHIPPING) return Order.ERROR_INVALID_ORDER_STATUS;
//		order.status = OrderStatus.CLOSED;
//		//IGNORE: unfinished implementation
//		return 0;
//	}
//
//	public List<OrderItem> cancelOrder(Order order) {
//		if (order.status != OrderStatus.SHOPPING_CART) return null;
//		order.status = OrderStatus.CANCELED;
//		//IGNORE: unfinished implementation
//		return order.items;
//	}
}
