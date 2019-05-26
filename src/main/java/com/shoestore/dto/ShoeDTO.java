package com.shoestore.dto;

import com.shoestore.entities.shoe.Photo;
import com.shoestore.entities.shoe.Shoe;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ShoeDTO extends BaseIdDTO{
    private String name;

    private String description;

    private List<String> photos;

    public ShoeDTO(Shoe shoe) {
        super(shoe);
        this.name = shoe.getName();
        this.description = shoe.getDescription();
        this.photos = shoe.getPhotos().stream()
                .map(Photo::getUrl)
                .collect(Collectors.toList());
    }
}
