package com.shoestore.services.impl;

import java.util.Arrays;
import java.util.List;

import com.shoestore.constants.Constants;
import com.shoestore.entities.inventory.ShoeAvailability;
import com.shoestore.entities.inventory.ShoeInventory;
import com.shoestore.entities.order.Order;
import com.shoestore.entities.order.OrderItem;
import com.shoestore.entities.order.OrderStatus;
import com.shoestore.entities.shoe.Shoe;
import com.shoestore.entities.shoe.ShoeSize;
import com.shoestore.repositories.ShoeInventoryRepository;
import com.shoestore.services.CartService;
import org.springframework.stereotype.Service;

import static com.shoestore.constants.Constants.*;

@Service
public class CartServiceImpl implements CartService {

	private final ShoeInventoryRepository shoeInventoryRepository;

	public CartServiceImpl(ShoeInventoryRepository shoeInventoryRepository) {
		this.shoeInventoryRepository = shoeInventoryRepository;
	}

	@Override
	public long depositPairs(Shoe shoe, Integer shoeSize, Integer additionalPairs) {
		ShoeInventory inventory = shoeInventoryRepository.findByShoe(shoe).orElse(null);
		if(null==inventory){
			return ERROR_OUT_OF_STOCK;
		}

		if (Arrays.stream(Constants.SizeEnum.values()).noneMatch(o -> shoeSize.equals(o.label))) {
			return ERROR_INVALID_SHOE_SIZE;
		} else if (additionalPairs <= 0 ) {
			return ERROR_NEGATIVE_DEPOSIT_AMOUNT;
		} else {
			ShoeAvailability availability = inventory.getShoeAvailability()
					.stream()
					.filter(o->o.getShoeSize().getCode().equals(shoeSize))
					.findFirst()
					.orElse(null);
			if(null==availability){
				return ERROR_ENTITY_NOT_FOUND;
			}
			availability.setAvailability(availability.getAvailability() + additionalPairs);
			return null != shoeInventoryRepository.save(inventory) ? SUCCESS : UNKNOWN_ERROR;
		}
	}

	@Override
	public long reservePair(ShoeInventory inventory, ShoeSize shoeSize) {
		ShoeAvailability availability = inventory.getShoeAvailability()
				.stream()
				.filter(o->o.getShoeSize().getCode().equals(shoeSize))
				.findFirst()
				.orElse(null);
		if (Arrays.stream(Constants.SizeEnum.values()).noneMatch(o -> shoeSize.equals(o.label))) {
			return ERROR_INVALID_SHOE_SIZE;
		} else if (null==availability || availability.getAvailability().equals(shoeSize.getCode())) {
			return ERROR_OUT_OF_STOCK;
		} else {
			availability.setAvailability(availability.getAvailability() - 1);
			return null != shoeInventoryRepository.save(inventory) ? SUCCESS : UNKNOWN_ERROR;
		}
	}
	
	@Override
	public long bumpVersion(Order order, long currentVersion) {
		if (currentVersion != order.getVersion())
			return ERROR_INCONSISTENT_VERSIONS_HISTORY;
		else {
			order.setVersion(currentVersion + 1);
			return order.getVersion();
		}
	}

    @Override
	public long addToCart(Order order, OrderItem orderItem) {
    	if (order.getStatus() != OrderStatus.SHOPPING_CART) return ERROR_INVALID_ORDER_STATUS;
		return order.getItems().add(orderItem) ? 0 : -100;
	}

    @Override
	public long removeFromCart(Order order, OrderItem orderItem) {
    	if (order.getStatus() != OrderStatus.SHOPPING_CART) return ERROR_INVALID_ORDER_STATUS;
		return order.getItems().remove(orderItem) ? 0 : -100;
	}

	@Override
	public long checkoutOrder(Order order) {
		if (order.getStatus() != OrderStatus.SHOPPING_CART) return ERROR_INVALID_ORDER_STATUS;
		order.setStatus(OrderStatus.CHECKED_OUT);
		return 0;
		//IGNORE: unfinished implementation
	}

	@Override
	public long shipOrder(Order order) {
		if (order.getStatus() != OrderStatus.CHECKED_OUT) return ERROR_INVALID_ORDER_STATUS;
		order.setStatus(OrderStatus.SHIPPING);
		//IGNORE: unfinished implementation
		return 0;
	}

	@Override
	public long completeOrder(Order order) {
		if (order.getStatus() != OrderStatus.SHIPPING) return ERROR_INVALID_ORDER_STATUS;
		order.setStatus(OrderStatus.CLOSED);
		//IGNORE: unfinished implementation
		return 0;
	}

	@Override
	public List<OrderItem> cancelOrder(Order order) {
		if (order.getStatus() != OrderStatus.SHOPPING_CART) return null;
		order.setStatus(OrderStatus.CANCELED);
		//IGNORE: unfinished implementation
		return order.getItems();
	}
}
