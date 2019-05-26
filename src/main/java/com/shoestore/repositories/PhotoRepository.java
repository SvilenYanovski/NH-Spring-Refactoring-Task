package com.shoestore.repositories;

import com.shoestore.entities.shoe.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
    Optional<Photo> findPhotoByUrl(String url);
}
