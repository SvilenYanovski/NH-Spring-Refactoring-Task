package com.shoestore.dto.converters;

import com.shoestore.dto.ShoeDTO;
import com.shoestore.entities.shoe.Photo;
import com.shoestore.entities.shoe.Shoe;
import com.shoestore.repositories.PhotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ShoeConverter {

    private final PhotoRepository photoRepository;

    public ShoeConverter(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public List<ShoeDTO> shoesToShoeDTOs(List<Shoe> shoes) {
        return shoes.stream()
                .filter(Objects::nonNull)
                .map(this::shoeToShoeDTO)
                .collect(Collectors.toList());
    }

    public ShoeDTO shoeToShoeDTO(Shoe shoe) {
        return new ShoeDTO(shoe);
    }

    public List<Shoe> shoeDTOsToShoes(List<ShoeDTO> shoeDTOs) {
        return shoeDTOs.stream()
                .filter(Objects::nonNull)
                .map(this::userDTOToUser)
                .collect(Collectors.toList());
    }

    public Shoe userDTOToUser(ShoeDTO shoeDTO) {
        if (shoeDTO == null) {
            return null;
        } else {
            Shoe shoe = new Shoe();
            shoe.setName(shoeDTO.getName());
            shoe.setDescription(shoeDTO.getDescription());

            List<Photo> photos = shoeDTO.getPhotos()
                    .stream()
                    .map(photoRepository::findPhotoByUrl)
                    .collect(Collectors.toList());
            shoe.setPhotos(photos);
            return shoe;
        }
    }
    public Shoe fromId(Long id) {
        if (id == null) {
            return null;
        }
        Shoe shoe = new Shoe();
        shoe.setId(id);
        return shoe;
    }
}
