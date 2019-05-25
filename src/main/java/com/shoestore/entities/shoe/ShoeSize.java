package com.shoestore.entities.shoe;

import com.shoestore.entities.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class ShoeSize  extends BaseEntity {

    private Integer code;

    public ShoeSize() {}
    public ShoeSize(Integer code) {
        this.code = code;
    }
}
