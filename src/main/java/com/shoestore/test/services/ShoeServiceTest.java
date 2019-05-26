package com.shoestore.test.services;

import com.shoestore.ShoeStoreApplication;
import com.shoestore.entities.shoe.Photo;
import com.shoestore.entities.shoe.Shoe;
import com.shoestore.repositories.PhotoRepository;
import com.shoestore.repositories.ShoeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShoeStoreApplication.class)
public class ShoeServiceTest {

    private static final String PHOTO_URL = "url";
    private static final String SHOE_DESCRIPTION = "desc";
    private static final String SHOE_NAME = "Shoe";

    private Shoe shoe;

    @Autowired
    private ShoeRepository shoeRepository;

    @Autowired
    private PhotoRepository photoRepository;

    @Before
    public void init() {
        shoe = new Shoe();
        shoe.setPhotos(Arrays.asList(photoRepository.save(new Photo(PHOTO_URL))));
        shoe.setDescription(SHOE_DESCRIPTION);
        shoe.setName(SHOE_NAME);
    }

    @Test
    public void serviceShouldReturnCorrectShoe(){
        Shoe saved = shoeRepository.save(shoe);
        Shoe retrieved = shoeRepository.findAll()
                .stream()
                .filter(o->o.getName().equals(SHOE_NAME))
                .findFirst()
                .orElse(null);

        assertNotNull(saved);
        assertNotNull(retrieved);
        assertEquals(saved.getId(), retrieved.getId());
    }
}
