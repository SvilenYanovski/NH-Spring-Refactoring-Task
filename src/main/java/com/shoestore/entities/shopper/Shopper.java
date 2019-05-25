package com.shoestore.entities.shopper;

import com.shoestore.entities.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Shopper  extends BaseEntity {

	private String username;

	public Shopper() {}
	public Shopper(String username) {
		this.username = username;
	}
}
