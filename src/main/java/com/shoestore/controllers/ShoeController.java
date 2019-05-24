package com.shoestore.controllers;

import com.shoestore.entities.Shoe;
import com.shoestore.repositories.ShoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShoeController {

    @Autowired
    private ShoeRepository shoeRepository;

    @GetMapping("/shoes")
    List<Shoe> all() {
        return shoeRepository.findAll();
    }
}
