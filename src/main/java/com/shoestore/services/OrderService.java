package com.shoestore.services;

import com.shoestore.dto.GenericResponseDTO;
import com.shoestore.dto.OrderDTO;
import com.shoestore.entities.shoe.ShoePair;

public interface OrderService {
    OrderDTO getOrder(long shopperId);
    GenericResponseDTO getTotalPrice(long shopperId);
    OrderDTO addShoePair(long shopperId, ShoePair shoePair);
    OrderDTO updateShoePair(long shopperId, ShoePair shoePair);
    OrderDTO removeShoePair(long shopperId, ShoePair shoePair);
}
