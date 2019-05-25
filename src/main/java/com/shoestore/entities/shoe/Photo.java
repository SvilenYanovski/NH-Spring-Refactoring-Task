package com.shoestore.entities.shoe;

import com.shoestore.entities.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Photo  extends BaseEntity {

    private String url;

    public Photo() {}
    public Photo(String url){
        this.url = url;
    }
}
