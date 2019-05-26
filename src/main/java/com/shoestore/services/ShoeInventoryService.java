package com.shoestore.services;

import com.shoestore.entities.inventory.ShoeInventory;

import java.util.List;

public interface ShoeInventoryService {
    List<ShoeInventory> getAll();
    Integer getAvailabilityByShoeAndSize(Long shoeId, Integer size);
}
