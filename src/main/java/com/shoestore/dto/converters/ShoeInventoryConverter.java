package com.shoestore.dto.converters;

import com.shoestore.dto.ShoeInventoryDTO;
import com.shoestore.entities.inventory.ShoeInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoeInventoryConverter implements BaseConverter<ShoeInventoryDTO, ShoeInventory>{

    @Autowired
    private ShoeConverter shoeConverter;
    @Autowired
    private ShoeAvailabilityConverter shoeAvailabilityConverter;

    @Override
    public ShoeInventoryDTO toDto(ShoeInventory shoe) {
        return new ShoeInventoryDTO(shoe);
    }

    @Override
    public ShoeInventory toEntity(ShoeInventoryDTO dto) {
        if (dto == null) {
            return null;
        } else {
            ShoeInventory shoe = new ShoeInventory();
            shoe.setShoe(shoeConverter.toEntity(dto.getShoeDto()));
            shoe.setShoeAvailability(shoeAvailabilityConverter.toEntities(dto.getShoeAvailability()));
            return shoe;
        }
    }

    @Override
    public ShoeInventory fromId(Long id) {
        if (id == null) {
            return null;
        }
        ShoeInventory entity = new ShoeInventory();
        entity.setId(id);
        return entity;
    }
}
