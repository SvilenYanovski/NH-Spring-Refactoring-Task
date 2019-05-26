package com.shoestore.services.impl;

import com.shoestore.dto.ShoeDTO;
import com.shoestore.dto.converters.ShoeConverter;
import com.shoestore.entities.shoe.Shoe;
import com.shoestore.repositories.ShoeRepository;
import com.shoestore.services.ShoeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoeServiceImpl implements ShoeService {

    private final ShoeRepository shoeRepository;
    private final ShoeConverter shoeConverter;

    public ShoeServiceImpl(ShoeRepository shoeRepository, ShoeConverter shoeConverter) {
        this.shoeRepository = shoeRepository;
        this.shoeConverter = shoeConverter;
    }

    @Override
    public List<ShoeDTO> getAll() {
        return shoeConverter.shoesToShoeDTOs(shoeRepository.findAll());
    }
}
