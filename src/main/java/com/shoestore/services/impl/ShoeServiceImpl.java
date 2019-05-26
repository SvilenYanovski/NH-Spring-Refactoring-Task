package com.shoestore.services.impl;

import com.shoestore.entities.shoe.Shoe;
import com.shoestore.repositories.ShoeRepository;
import com.shoestore.services.ShoeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoeServiceImpl implements ShoeService {

    private final ShoeRepository shoeRepository;

    public ShoeServiceImpl(ShoeRepository shoeRepository) {
        this.shoeRepository = shoeRepository;
    }

    @Override
    public List<Shoe> getAll() {
        return shoeRepository.findAll();
    }
}
