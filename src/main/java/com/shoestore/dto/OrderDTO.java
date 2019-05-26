package com.shoestore.dto;

import com.shoestore.entities.BaseIdEntity;
import com.shoestore.entities.order.Order;
import com.shoestore.entities.order.OrderStatus;
import lombok.Data;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
public class OrderDTO extends BaseIdDTO {

    private Long shopperId;
    private String shopperUsername;

    private List<Long> orderItems;
    private OrderStatus status;
    private long version = 0l;
    private Double price = 0.0;

    public OrderDTO(Order order) {
        super(order);
        this.shopperId = order.getShopper().getId();
        this.shopperUsername = order.getShopper().getUsername();
        this.orderItems = order.getItems()
                .stream()
                .filter(Objects::nonNull)
                .map(BaseIdEntity::getId)
                .collect(Collectors.toList());
        this.status = order.getStatus();
        this.version = order.getVersion();
        this.price = order.getPrice();
    }
}
