package com.shoestore.services;

import com.shoestore.entities.inventory.ShoeAvailability;
import com.shoestore.entities.inventory.ShoeInventory;
import com.shoestore.repositories.ShoeAvailabilityRepository;
import com.shoestore.repositories.ShoeInventoryRepository;
import com.shoestore.repositories.ShoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoeInventoryService {

    @Autowired
    private ShoeInventoryRepository shoeInventoryRepository;
    @Autowired
    private ShoeAvailabilityRepository shoeAvailabilityRepository;
    @Autowired
    private ShoeRepository shoeRepository;

    public List<ShoeInventory> getAll(){
        return shoeInventoryRepository.findAll();
    }

    public Integer getAvailabilityByShoeAndSize(Long shoeId, Integer size){
        ShoeInventory inventory = shoeInventoryRepository.findByShoe(shoeRepository.findById(shoeId).orElse(null)).orElse(null);
        if(null==inventory){
            return 0;
        }
        return inventory.getShoeAvailability().stream().filter(o->size.equals(o.getShoeSize().getCode())).findFirst().map(ShoeAvailability::getAvailability).orElse(0);
    }
}
