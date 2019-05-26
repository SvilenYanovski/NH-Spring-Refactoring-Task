package com.shoestore.services;

import com.shoestore.dto.GenericResponseDTO;
import com.shoestore.dto.ShoeInventoryDTO;

import java.util.List;

public interface ShoeInventoryService {
    List<ShoeInventoryDTO> getAll();
    GenericResponseDTO getAvailabilityByShoeAndSize(Long shoeId, Integer size);
}
