package com.shoestore.controllers;

import com.shoestore.dto.GenericResponseDTO;
import com.shoestore.dto.ShoeInventoryDTO;
import com.shoestore.services.ShoeInventoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/inventory")
public class InventoryController {

    private static final Logger LOGGER = LogManager.getLogger(InventoryController.class);

    private final ShoeInventoryService shoeInventoryService;

    public InventoryController(ShoeInventoryService shoeInventoryService) {
        this.shoeInventoryService = shoeInventoryService;
    }

    @GetMapping("/all")
    List<ShoeInventoryDTO> all() {
        LOGGER.info("Request to load all Shoe Inventories.");
        return shoeInventoryService.getAll();
    }

    @GetMapping("/{shoeId}/{size}")
    GenericResponseDTO getBySize(@PathVariable("shoeId") Long shoeId,
                                 @PathVariable("size") Integer size) {
        LOGGER.info("Request to load Shoe Avalability for ShoeId {} with Size {}", shoeId, size);
        return shoeInventoryService.getAvailabilityByShoeAndSize(shoeId, size);
    }
}
