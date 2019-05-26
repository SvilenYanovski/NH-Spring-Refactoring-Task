package com.shoestore.test.converters;

import com.shoestore.ShoeStoreApplication;
import com.shoestore.dto.ShoeDTO;
import com.shoestore.dto.converters.ShoeConverter;
import com.shoestore.entities.shoe.Photo;
import com.shoestore.entities.shoe.Shoe;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShoeStoreApplication.class)
public class ShoeConverterTest {

    private static final String PHOTO_URL = "url";
    private static final String SHOE_DESCRIPTION = "desc";
    private static final String SHOE_NAME = "Shoe";

    @Autowired
    private ShoeConverter shoeConverter;

    private Shoe shoe;
    private ShoeDTO shoeDTO;

    @Before
    public void init() {
        shoe = new Shoe();
        shoe.setId(1L);
        shoe.setPhotos(Arrays.asList(new Photo(PHOTO_URL)));
        shoe.setDescription(SHOE_DESCRIPTION);
        shoe.setName(SHOE_NAME);

        shoeDTO = new ShoeDTO(shoe);
    }

    @Test
    public void shoesToShoeDTOsShouldMapOnlyNonNullShoes(){
        List<Shoe> shoes = new ArrayList<>();
        shoes.add(shoe);
        shoes.add(null);

        List<ShoeDTO> shoesDTOs = shoeConverter.toDtos(shoes);

        assertNotNull(shoesDTOs);
        assertEquals(1, shoesDTOs.size());
    }

    @Test
    public void shoesDtosToShoeShouldMapOnlyNonNullShoes(){
        List<ShoeDTO> shoeDtos = new ArrayList<>();
        shoeDtos.add(shoeDTO);
        shoeDtos.add(null);

        List<Shoe> shoes = shoeConverter.toEntities(shoeDtos);

        assertNotNull(shoes);
        assertEquals(1, shoes.size());
    }

    @Test
    public void shoeAndShoeDTOpropertiesShouldMatch(){
        ShoeDTO testDto = shoeConverter.toDto(shoe);
        Shoe testEntity = shoeConverter.toEntity(shoeDTO);

        assertEquals(testDto.getDescription(), SHOE_DESCRIPTION);
        assertEquals(testDto.getName(), SHOE_NAME);
        assertEquals(testDto.getPhotos().get(0), PHOTO_URL);
        assertEquals(testEntity.getDescription(), SHOE_DESCRIPTION);
        assertEquals(testEntity.getName(), SHOE_NAME);
    }
}
