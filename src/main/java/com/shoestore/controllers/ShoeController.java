package com.shoestore.controllers;

import com.shoestore.entities.shoe.Shoe;
import com.shoestore.services.ShoeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/shoe")
public class ShoeController {

    private static final Logger LOGGER = LogManager.getLogger(ShoeController.class);

    private final ShoeService shoeService;

    public ShoeController(ShoeService shoeService) {
        this.shoeService = shoeService;
    }

    @GetMapping("/all")
    List<Shoe> all() {
        LOGGER.info("Fetching all shoes.");
        return shoeService.getAll();
    }
}
