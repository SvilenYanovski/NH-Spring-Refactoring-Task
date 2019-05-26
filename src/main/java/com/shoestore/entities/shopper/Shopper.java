package com.shoestore.entities.shopper;

import com.shoestore.entities.BaseIdEntity;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Shopper  extends BaseIdEntity {

	private String username;

	public Shopper() {}
	public Shopper(String username) {
		this.username = username;
	}
}
