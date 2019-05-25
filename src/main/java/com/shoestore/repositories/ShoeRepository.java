package com.shoestore.repositories;

import com.shoestore.entities.shoe.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoeRepository extends JpaRepository<Shoe, Long> {
}
