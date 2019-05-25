package com.shoestore.config;

import com.shoestore.constants.Constants;
import com.shoestore.entities.inventory.ShoeAvailability;
import com.shoestore.entities.inventory.ShoeInventory;
import com.shoestore.entities.shoe.Photo;
import com.shoestore.entities.shoe.Shoe;
import com.shoestore.entities.shoe.ShoeSize;
import com.shoestore.entities.shopper.Shopper;
import com.shoestore.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(ShopperRepository shopperRepository,
                                   ShoeRepository shoeRepository,
                                   PhotoRepository photoRepository,
                                   ShoeSizeRepository shoeSizeRepository,
                                   ShoeInventoryRepository shoeInventoryRepository,
                                   ShoeAvailabilityRepository availabilityRepository) {
        return args -> {
            shopperRepository.save(new Shopper("first_shopper"));
            shopperRepository.save(new Shopper("second_shopper"));

            Photo p1 = new Photo("url1");
            Photo p2 = new Photo("url2");
            photoRepository.save(p1);
            photoRepository.save(p2);

            Shoe nike = new Shoe("Nike", "description", Arrays.asList(p1));
            Shoe adidas = new Shoe("Adidas", "description", Arrays.asList(p2));
            shoeRepository.save(nike);
            shoeRepository.save(adidas);

            ShoeSize size40 = new ShoeSize(Constants.SizeEnum.SIZE40.label);
            ShoeSize size41 = new ShoeSize(Constants.SizeEnum.SIZE41.label);
            ShoeSize size42 = new ShoeSize(Constants.SizeEnum.SIZE42.label);
            shoeSizeRepository.save(size40);
            shoeSizeRepository.save(size41);
            shoeSizeRepository.save(size42);

            ShoeAvailability nike40 = new ShoeAvailability(size40, 2);
            ShoeAvailability nike41 = new ShoeAvailability(size41, 5);
            ShoeAvailability adidas40 = new ShoeAvailability(size40, 6);
            ShoeAvailability adidas42 = new ShoeAvailability(size42, 2);
            availabilityRepository.save(nike40);
            availabilityRepository.save(nike41);
            availabilityRepository.save(adidas40);
            availabilityRepository.save(adidas42);

            ShoeInventory nikeInv = new ShoeInventory(nike, Arrays.asList(nike40, nike41));

            ShoeInventory adidasInv = new ShoeInventory(adidas, Arrays.asList(adidas40, adidas42));

            shoeInventoryRepository.save(nikeInv);
            shoeInventoryRepository.save(adidasInv);
        };
    }
}
