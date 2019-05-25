package com.shoestore.repositories;

import com.shoestore.entities.shopper.Shopper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopperRepository extends JpaRepository<Shopper, Long> {
}
