package com.shoestore.repositories;

import com.shoestore.entities.inventory.ShoeAvailability;
import com.shoestore.entities.shoe.ShoeSize;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShoeAvailabilityRepository extends JpaRepository<ShoeAvailability, Long> {
    Optional<ShoeAvailability> findByShoeSize(ShoeSize shoeSize);
}
