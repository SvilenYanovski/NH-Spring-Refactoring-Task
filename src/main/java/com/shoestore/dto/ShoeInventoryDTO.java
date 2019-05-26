package com.shoestore.dto;

import com.shoestore.entities.inventory.ShoeInventory;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ShoeInventoryDTO extends BaseIdDTO{
    private ShoeDTO shoeDto;

    private List<ShoeAvailabilityDTO> shoeAvailability;

    public ShoeInventoryDTO(ShoeInventory shoeInventory){
        super(shoeInventory);
        this.shoeDto = new ShoeDTO(shoeInventory.getShoe());
        this.shoeAvailability = shoeInventory.getShoeAvailability()
                .stream()
                .map(ShoeAvailabilityDTO::new)
                .collect(Collectors.toList());
    }
}
