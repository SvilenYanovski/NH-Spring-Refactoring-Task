package com.shoestore.entities.shoe;

import com.shoestore.entities.BaseIdEntity;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Photo  extends BaseIdEntity {

    private String url;

    public Photo() {}
    public Photo(String url){
        this.url = url;
    }
}
