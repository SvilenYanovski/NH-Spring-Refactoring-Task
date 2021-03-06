package com.shoestore.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public abstract class BaseIdEntity implements BaseEntity{
    @Id
    @GeneratedValue
    private Long id;
}
