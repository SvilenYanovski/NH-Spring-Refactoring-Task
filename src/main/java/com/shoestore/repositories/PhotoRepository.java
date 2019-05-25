package com.shoestore.repositories;

import com.shoestore.entities.shoe.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
