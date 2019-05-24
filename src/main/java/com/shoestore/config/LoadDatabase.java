package com.shoestore.config;

import com.shoestore.entities.Photo;
import com.shoestore.entities.Shoe;
import com.shoestore.entities.Shopper;
import com.shoestore.repositories.PhotoRepository;
import com.shoestore.repositories.ShoeRepository;
import com.shoestore.repositories.ShopperRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(ShopperRepository shopperRepository, ShoeRepository shoeRepository, PhotoRepository photoRepository) {
        return args -> {
            shopperRepository.save(new Shopper("first_shopper"));
            shopperRepository.save(new Shopper("second_shopper"));

            Photo p1 = new Photo("url1");
            Photo p2 = new Photo("url2");
            photoRepository.save(p1);
            photoRepository.save(p2);

            shoeRepository.save(new Shoe("Nike", "description", Arrays.asList(p1)));
            shoeRepository.save(new Shoe("Adidas", "description", Arrays.asList(p2)));
        };
    }
}
