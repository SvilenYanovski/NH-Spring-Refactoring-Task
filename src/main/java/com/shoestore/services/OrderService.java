package com.shoestore.services;

import com.shoestore.entities.order.Order;
import com.shoestore.entities.shoe.ShoePair;

import javax.websocket.server.PathParam;

public interface OrderService {
    Order getOrder(long shopperId);
    Double getTotalPrice(long shopperId);
    Order addShoePair(long shopperId, ShoePair shoePair);
    Order updateShoePair(long shopperId, ShoePair shoePair);
    Order removeShoePair(long shopperId, ShoePair shoePair);
}
