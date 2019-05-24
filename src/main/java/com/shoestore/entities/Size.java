package com.shoestore.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@Entity
public class Size {
    @Id
    @GeneratedValue
    private Long id;
    private int size;
    @ManyToMany
    private List<Shoe> shoe;

    public Size() {}
    public Size(int size){
        this.size = size;
    }
}
