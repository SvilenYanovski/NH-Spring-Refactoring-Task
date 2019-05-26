package com.shoestore.services;

import com.shoestore.dto.ShoeDTO;

import java.util.List;

public interface ShoeService {
    List<ShoeDTO> getAll();
}
