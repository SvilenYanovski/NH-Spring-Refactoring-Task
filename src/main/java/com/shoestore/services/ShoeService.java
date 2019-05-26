package com.shoestore.services;

import com.shoestore.entities.shoe.Shoe;

import java.util.List;

public interface ShoeService {
    List<Shoe> getAll();
}
