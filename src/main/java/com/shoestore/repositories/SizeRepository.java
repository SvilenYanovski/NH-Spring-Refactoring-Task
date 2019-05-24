package com.shoestore.repositories;

import com.shoestore.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeRepository extends JpaRepository<Size, Long> {
}
