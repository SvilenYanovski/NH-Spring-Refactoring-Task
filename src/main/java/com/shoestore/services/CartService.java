package com.shoestore.services;

import com.shoestore.entities.inventory.ShoeInventory;
import com.shoestore.entities.order.Order;
import com.shoestore.entities.order.OrderItem;
import com.shoestore.entities.shoe.Shoe;
import com.shoestore.entities.shoe.ShoeSize;

import java.util.List;

public interface CartService {
    long depositPairs(Shoe shoe, Integer shoeSize, Integer additionalPairs);
    long reservePair(ShoeInventory inventory, ShoeSize shoeSize);
    long bumpVersion(Order order, long currentVersion);
    long addToCart(Order order, OrderItem orderItem);
    long removeFromCart(Order order, OrderItem orderItem);
    long checkoutOrder(Order order);
    long shipOrder(Order order);
    long completeOrder(Order order);
    List<OrderItem> cancelOrder(Order order);
}
