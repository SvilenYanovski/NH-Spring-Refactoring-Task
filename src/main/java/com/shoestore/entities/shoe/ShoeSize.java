package com.shoestore.entities.shoe;

import com.shoestore.entities.BaseIdEntity;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class ShoeSize  extends BaseIdEntity {

    private Integer code;

    public ShoeSize() {}
    public ShoeSize(Integer code) {
        this.code = code;
    }
}
