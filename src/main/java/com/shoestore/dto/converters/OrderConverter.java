package com.shoestore.dto.converters;

import com.shoestore.dto.OrderDTO;
import com.shoestore.entities.order.Order;
import com.shoestore.repositories.OrderItemRepository;
import com.shoestore.repositories.ShopperRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class OrderConverter implements BaseConverter<OrderDTO, Order> {

    private final ShopperRepository shopperRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderConverter(ShopperRepository shopperRepository, OrderItemRepository orderItemRepository) {
        this.shopperRepository = shopperRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public OrderDTO toDto(Order entity) {
        return new OrderDTO(entity);
    }

    @Override
    public Order toEntity(OrderDTO dto) {
        if (dto == null) {
            return null;
        } else {
            Order entity = new Order();
            entity.setStatus(dto.getStatus());
            entity.setVersion(dto.getVersion());
            entity.setPrice(dto.getPrice());
            entity.setShopper(shopperRepository.findById(dto.getShopperId()).orElse(null));
            entity.setItems(dto.getOrderItems()
                    .stream()
                    .map(o->orderItemRepository.findById(o)
                            .orElse(null))
                    .collect(Collectors.toList()));
            return entity;
        }
    }

    @Override
    public Order fromId(Long id) {
        if (id == null) {
            return null;
        }
        Order entity = new Order();
        entity.setId(id);
        return entity;
    }
}
