package com.shoestore.repositories;

import com.shoestore.entities.shoe.Shoe;
import com.shoestore.entities.inventory.ShoeInventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShoeInventoryRepository extends JpaRepository<ShoeInventory, Long> {
    Optional<ShoeInventory> findByShoe(Shoe shoe);

//    @Query("SELECT i.size42 FROM ShoeInventory i WHERE i.shoe = :shoe")
//    int findBySize42(@Param("shoe") Shoe shoe);

}
