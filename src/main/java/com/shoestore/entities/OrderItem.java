package com.shoestore.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public abstract class OrderItem {
	@Id
	@GeneratedValue
	private long id;
}
