package com.shoestore.services.impl;

import com.shoestore.dto.GenericResponseDTO;
import com.shoestore.dto.OrderDTO;
import com.shoestore.dto.converters.OrderConverter;
import com.shoestore.entities.inventory.ShoeInventory;
import com.shoestore.entities.order.Order;
import com.shoestore.entities.shoe.ShoePair;
import com.shoestore.entities.shopper.Shopper;
import com.shoestore.repositories.OrderRepository;
import com.shoestore.repositories.ShoeInventoryRepository;
import com.shoestore.repositories.ShopperRepository;
import com.shoestore.services.CartService;
import com.shoestore.services.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger LOGGER = LogManager.getLogger(OrderServiceImpl.class);

    private final OrderRepository orderRepository;
    private final ShopperRepository shopperRepository;
    private final ShoeInventoryRepository inventoryRepository;
    private final CartService cartService;
    private final OrderConverter orderConverter;

    public OrderServiceImpl(OrderRepository orderRepository,
                            ShopperRepository shopperRepository,
                            ShoeInventoryRepository inventoryRepository,
                            CartService cartService,
                            OrderConverter orderConverter) {
        this.orderRepository = orderRepository;
        this.shopperRepository = shopperRepository;
        this.inventoryRepository = inventoryRepository;
        this.cartService = cartService;
        this.orderConverter = orderConverter;
    }

    @Override
    public OrderDTO getOrder(long shopperId) {
        LOGGER.info("About to retrieve shopper with id: " + shopperId);
        Shopper shopper = shopperRepository.findById(shopperId).orElse(null);
        if(null == shopper){
            LOGGER.error("Invalid shopper Id or Shopper does not exists: " + shopperId);
            return null;
        }

        LOGGER.info("About to retrieve existing order for shopper.");
        Order order = orderRepository.findByShopperId(shopperId).orElse(null);
        if (order != null) {
            LOGGER.info("Found existing order for shopper. Order id: " + order.getId());
            return  orderConverter.toDto(order);
        }else {
            LOGGER.warn("Not found existing order. Creating new one.");
            order = new Order();
            order.setShopper(shopper);
            order = orderRepository.save(order);

            return orderConverter.toDto(order);
        }
    }

    @Override
    public GenericResponseDTO getTotalPrice(long shopperId) {
        GenericResponseDTO response = new GenericResponseDTO();

        LOGGER.info("About to retrieve total price for the existing order of shopper id: " + shopperId);
        Double price = orderRepository.findByShopperId(shopperId).map(Order::getPrice).orElse(0.0);
        if(0.0 == price){
            response.getErrors().add("Fresh order or the price is not calculated yet.");
        }

        response.setValue(price.toString());

        return response;
    }

    @Override
    public OrderDTO addShoePair(long shopperId, ShoePair shoePair) {
        LOGGER.info("About to retrieve inventory for shoe pair id: " + shoePair.getId());
        ShoeInventory inventory = inventoryRepository.findByShoe(shoePair.getShoe()).orElse(null);
        if (inventory == null) {
            LOGGER.error("Unable to retrieve inventory.");
            return null;
        } else {
            Order order = orderRepository.findByShopperId(shopperId).orElse(null);
            if (order == null) {
                LOGGER.error("Unable to retrieve current order for shopper id: " + shopperId);
                return null;
            } else {
                long errorCode = cartService.reservePair(inventory, shoePair.getShoeSize());
                if (errorCode < 0) {
                    LOGGER.error("Unable to reserve shoe pair. Error code: " + errorCode);
                    return null;
                }

                long addToCartCode = cartService.addToCart(order, shoePair);
                if(addToCartCode < 0){
                    LOGGER.error("Unable to add to cart the shoe pair. Error code: " + addToCartCode);
                    return null;
                }
                return  orderConverter.toDto(order);
            }
        }
    }

    @Override
    public OrderDTO updateShoePair(long shopperId, ShoePair shoePair) {
        //IGNORE: to be implemented
        return null;
    }

    @Override
    public OrderDTO removeShoePair(long shopperId, ShoePair shoePair) {
        //IGNORE: to be implemented
        return null;
    }
}
