package com.shoestore.dto;

import com.shoestore.entities.inventory.ShoeAvailability;
import lombok.Data;

@Data
public class ShoeAvailabilityDTO extends BaseIdDTO {
    private Integer shoeSize;

    private Integer availability;

    public ShoeAvailabilityDTO(ShoeAvailability shoeAvailability){
        super(shoeAvailability);
        this.shoeSize = shoeAvailability.getShoeSize().getCode();
        this.availability = shoeAvailability.getAvailability();
    }
}
