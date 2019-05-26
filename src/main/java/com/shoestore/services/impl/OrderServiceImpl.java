package com.shoestore.services.impl;

import com.shoestore.entities.inventory.ShoeInventory;
import com.shoestore.entities.order.Order;
import com.shoestore.entities.shoe.ShoePair;
import com.shoestore.repositories.OrderRepository;
import com.shoestore.repositories.ShoeInventoryRepository;
import com.shoestore.repositories.ShopperRepository;
import com.shoestore.services.CartService;
import com.shoestore.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ShopperRepository shopperRepository;
    private final ShoeInventoryRepository inventoryRepository;
    private final CartService cartService;

    public OrderServiceImpl(OrderRepository orderRepository, ShopperRepository shopperRepository, ShoeInventoryRepository inventoryRepository, CartService cartService) {
        this.orderRepository = orderRepository;
        this.shopperRepository = shopperRepository;
        this.inventoryRepository = inventoryRepository;
        this.cartService = cartService;
    }

    @Override
    public Order getOrder(long shopperId) {
        Order order = orderRepository.findByShopperId(shopperId).orElse(null);
        if (order != null) return order;
        return new Order(shopperRepository.getOne(shopperId));
    }

    @Override
    public Double getTotalPrice(long shopperId) {
        return orderRepository.findByShopperId(shopperId).map(Order::getPrice).orElse(0.0);
    }

    @Override
    public Order addShoePair(long shopperId, ShoePair shoePair) {
        ShoeInventory inventory = inventoryRepository.findByShoe(shoePair.getShoe()).orElse(null);
        if (inventory == null) {
            return null;
        } else {
            Order order = orderRepository.findByShopperId(shopperId).orElse(null);
            if (order == null) {
                return null;
            } else {
                long errorCode = cartService.reservePair(inventory, shoePair.getShoeSize());
                if (errorCode < 0) return null;

                return cartService.addToCart(order, shoePair) > 0 ? order : null;
            }
        }
    }

    @Override
    public Order updateShoePair(long shopperId, ShoePair shoePair) {
        //IGNORE: to be implemented
        return null;
    }

    @Override
    public Order removeShoePair(long shopperId, ShoePair shoePair) {
        //IGNORE: to be implemented
        return null;
    }
}
