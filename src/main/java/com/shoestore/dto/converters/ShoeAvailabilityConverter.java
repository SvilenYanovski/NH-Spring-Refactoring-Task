package com.shoestore.dto.converters;

import com.shoestore.dto.ShoeAvailabilityDTO;
import com.shoestore.entities.inventory.ShoeAvailability;
import com.shoestore.entities.shoe.ShoeSize;
import com.shoestore.repositories.ShoeSizeRepository;
import org.springframework.stereotype.Service;

@Service
public class ShoeAvailabilityConverter implements BaseConverter<ShoeAvailabilityDTO, ShoeAvailability>{

    private final ShoeSizeRepository shoeSizeRepository;

    public ShoeAvailabilityConverter(ShoeSizeRepository shoeSizeRepository) {
        this.shoeSizeRepository = shoeSizeRepository;
    }

    @Override
    public ShoeAvailabilityDTO toDto(ShoeAvailability shoe) {
        return new ShoeAvailabilityDTO(shoe);
    }

    @Override
    public ShoeAvailability toEntity(ShoeAvailabilityDTO shoeDTO) {
        if (shoeDTO == null) {
            return null;
        } else {
            ShoeAvailability shoe = new ShoeAvailability();
            shoe.setAvailability(shoeDTO.getAvailability());

            ShoeSize size = shoeSizeRepository.findByCode(shoeDTO.getShoeSize()).orElse(null);
            shoe.setShoeSize(size);
            return shoe;
        }
    }

    @Override
    public ShoeAvailability fromId(Long id) {
        if (id == null) {
            return null;
        }
        ShoeAvailability shoe = new ShoeAvailability();
        shoe.setId(id);
        return shoe;
    }
}
