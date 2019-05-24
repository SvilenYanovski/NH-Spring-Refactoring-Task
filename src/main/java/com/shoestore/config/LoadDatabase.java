package com.shoestore.config;

import com.shoestore.entities.Photo;
import com.shoestore.entities.Shoe;
import com.shoestore.entities.Shopper;
import com.shoestore.entities.Size;
import com.shoestore.repositories.PhotoRepository;
import com.shoestore.repositories.ShoeRepository;
import com.shoestore.repositories.ShopperRepository;
import com.shoestore.repositories.SizeRepository;
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
                                   SizeRepository sizeRepository) {
        return args -> {
            shopperRepository.save(new Shopper("first_shopper"));
            shopperRepository.save(new Shopper("second_shopper"));

            Photo p1 = new Photo("url1");
            Photo p2 = new Photo("url2");
            photoRepository.save(p1);
            photoRepository.save(p2);

            Size s40 = new Size(40);
            Size s41 = new Size(41);
            Size s42 = new Size(42);
            sizeRepository.save(s40);
            sizeRepository.save(s41);
            sizeRepository.save(s42);

            shoeRepository.save(new Shoe("Nike", "description", Arrays.asList(p1), Arrays.asList(s40, s41, s42)));
            shoeRepository.save(new Shoe("Adidas", "description", Arrays.asList(p2), Arrays.asList(s40, s41, s42)));
        };
    }
}
