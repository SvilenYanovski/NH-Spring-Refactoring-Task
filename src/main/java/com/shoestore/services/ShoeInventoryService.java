package com.shoestore.services;

import com.shoestore.dto.ShoeInventoryDTO;
import com.shoestore.entities.inventory.ShoeInventory;

import java.util.List;

public interface ShoeInventoryService {
    List<ShoeInventoryDTO> getAll();
    Integer getAvailabilityByShoeAndSize(Long shoeId, Integer size);
}
