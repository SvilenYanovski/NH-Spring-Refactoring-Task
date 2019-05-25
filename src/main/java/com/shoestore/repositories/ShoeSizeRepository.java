package com.shoestore.repositories;

import com.shoestore.entities.shoe.ShoeSize;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShoeSizeRepository extends JpaRepository<ShoeSize, Long> {
    Optional<ShoeSize> findByCode(Integer code);
}
