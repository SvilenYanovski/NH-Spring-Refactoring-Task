package com.shoestore.entities.inventory;

import com.shoestore.entities.BaseEntity;
import com.shoestore.entities.shoe.ShoeSize;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@Entity
public class ShoeAvailability extends BaseEntity {

    @ManyToOne
    private ShoeSize shoeSize;

    private Integer availability;

    public ShoeAvailability() {}
    public ShoeAvailability(ShoeSize shoeSize, Integer availability){
        this.shoeSize = shoeSize;
        this.availability = availability;
    }
}
