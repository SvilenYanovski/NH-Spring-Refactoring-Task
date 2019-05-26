package com.shoestore.services.impl;

import com.shoestore.dto.GenericResponseDTO;
import com.shoestore.dto.ShoeInventoryDTO;
import com.shoestore.dto.converters.ShoeInventoryConverter;
import com.shoestore.entities.inventory.ShoeAvailability;
import com.shoestore.entities.inventory.ShoeInventory;
import com.shoestore.repositories.ShoeAvailabilityRepository;
import com.shoestore.repositories.ShoeInventoryRepository;
import com.shoestore.repositories.ShoeRepository;
import com.shoestore.services.ShoeInventoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoeInventoryServiceImpl implements ShoeInventoryService {

    private static final Logger LOGGER = LogManager.getLogger(ShoeInventoryServiceImpl.class);

    private final ShoeInventoryRepository shoeInventoryRepository;
    private final ShoeAvailabilityRepository shoeAvailabilityRepository;
    private final ShoeRepository shoeRepository;
    private final ShoeInventoryConverter shoeInventoryConverter;

    public ShoeInventoryServiceImpl(ShoeInventoryRepository shoeInventoryRepository,
                                    ShoeAvailabilityRepository shoeAvailabilityRepository,
                                    ShoeRepository shoeRepository,
                                    ShoeInventoryConverter shoeInventoryConverter) {
        this.shoeInventoryRepository = shoeInventoryRepository;
        this.shoeAvailabilityRepository = shoeAvailabilityRepository;
        this.shoeRepository = shoeRepository;
        this.shoeInventoryConverter = shoeInventoryConverter;
    }

    @Override
    public List<ShoeInventoryDTO> getAll(){
        return shoeInventoryConverter.toDtos(shoeInventoryRepository.findAll());
    }

    /**
     * Return availability with default value of 0 if not found.
     * GenericResponseDTO to be used in the client app for parsing the response and/or errors.
     *
     * @param shoeId
     * @param size
     * @return
     */
    @Override
    public GenericResponseDTO getAvailabilityByShoeAndSize(Long shoeId, Integer size){
        GenericResponseDTO response = new GenericResponseDTO();

        LOGGER.info("About to retrieve inventory for shoe id: " + shoeId);
        ShoeInventory inventory = shoeInventoryRepository
                        .findByShoe(shoeRepository.findById(shoeId).orElse(null))
                        .orElse(null);

        if(null==inventory){
            String errorMsg = String.format("Unable to load inventory for shoe id %s and size %s", shoeId, size);
            response.getErrors().add(errorMsg);
            LOGGER.error(errorMsg);
        }else{
            LOGGER.info("About to retrieve availability for size: " + size);
            Integer available = inventory.getShoeAvailability()
                    .stream()
                    .filter(o->size.equals(o.getShoeSize().getCode()))
                    .findFirst()
                    .map(ShoeAvailability::getAvailability)
                    .orElse(0);

            if(0 == available){
                response.getErrors().add("Out of stock for the desired size: " + size);
            }
            response.setValue(available.toString());
        }
        return response;
    }
}
