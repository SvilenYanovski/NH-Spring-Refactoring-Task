package com.shoestore.dto.converters;

import com.shoestore.dto.ShoeDTO;
import com.shoestore.entities.shoe.Photo;
import com.shoestore.entities.shoe.Shoe;
import com.shoestore.repositories.PhotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoeConverter implements BaseConverter<ShoeDTO, Shoe>{

    private final PhotoRepository photoRepository;

    public ShoeConverter(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public ShoeDTO toDto(Shoe shoe) {
        return new ShoeDTO(shoe);
    }

    @Override
    public Shoe toEntity(ShoeDTO shoeDTO) {
        if (shoeDTO == null) {
            return null;
        } else {
            Shoe shoe = new Shoe();
            shoe.setName(shoeDTO.getName());
            shoe.setDescription(shoeDTO.getDescription());

            List<Photo> photos = shoeDTO.getPhotos()
                    .stream()
                    .map(o->photoRepository.findPhotoByUrl(o).orElse(null))
                    .collect(Collectors.toList());
            shoe.setPhotos(photos);
            return shoe;
        }
    }

    @Override
    public Shoe fromId(Long id) {
        if (id == null) {
            return null;
        }
        Shoe shoe = new Shoe();
        shoe.setId(id);
        return shoe;
    }
}
