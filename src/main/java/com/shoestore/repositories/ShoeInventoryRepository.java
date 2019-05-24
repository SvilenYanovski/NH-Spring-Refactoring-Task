package com.shoestore.repositories;

import com.shoestore.entities.ShoeInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoeInventoryRepository extends JpaRepository<ShoeInventory, Long> {
    public ShoeInventory findByShoeId(Long shoeId);
}
