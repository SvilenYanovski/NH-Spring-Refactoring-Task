package com.shoestore.services.impl;

import com.shoestore.dto.ShoeInventoryDTO;
import com.shoestore.dto.converters.ShoeInventoryConverter;
import com.shoestore.entities.inventory.ShoeAvailability;
import com.shoestore.entities.inventory.ShoeInventory;
import com.shoestore.repositories.ShoeAvailabilityRepository;
import com.shoestore.repositories.ShoeInventoryRepository;
import com.shoestore.repositories.ShoeRepository;
import com.shoestore.services.ShoeInventoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoeInventoryServiceImpl implements ShoeInventoryService {

    private final ShoeInventoryRepository shoeInventoryRepository;
    private final ShoeAvailabilityRepository shoeAvailabilityRepository;
    private final ShoeRepository shoeRepository;
    private final ShoeInventoryConverter shoeInventoryConverter;

    public ShoeInventoryServiceImpl(ShoeInventoryRepository shoeInventoryRepository,
                                    ShoeAvailabilityRepository shoeAvailabilityRepository,
                                    ShoeRepository shoeRepository,
                                    ShoeInventoryConverter shoeInventoryConverter) {
        this.shoeInventoryRepository = shoeInventoryRepository;
        this.shoeAvailabilityRepository = shoeAvailabilityRepository;
        this.shoeRepository = shoeRepository;
        this.shoeInventoryConverter = shoeInventoryConverter;
    }

    @Override
    public List<ShoeInventoryDTO> getAll(){
        return shoeInventoryConverter.toDtos(shoeInventoryRepository.findAll());
    }

    @Override
    public Integer getAvailabilityByShoeAndSize(Long shoeId, Integer size){
        ShoeInventory inventory = shoeInventoryRepository
                        .findByShoe(shoeRepository.findById(shoeId).orElse(null))
                        .orElse(null);
        if(null==inventory){
            return 0;
        }
        return inventory.getShoeAvailability()
                .stream()
                .filter(o->size.equals(o.getShoeSize().getCode()))
                .findFirst()
                .map(ShoeAvailability::getAvailability)
                .orElse(0);
    }
}
