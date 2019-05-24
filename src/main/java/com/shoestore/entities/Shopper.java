package com.shoestore.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Shopper {
	@Id
	@GeneratedValue
	private long id;
	private String username;

	public Shopper() {}
	public Shopper(String username) {
		this.username = username;
	}
}
