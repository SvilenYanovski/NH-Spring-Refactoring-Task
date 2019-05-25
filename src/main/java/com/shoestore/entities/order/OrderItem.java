package com.shoestore.entities.order;

import com.shoestore.entities.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public abstract class OrderItem  extends BaseEntity {
}
