package com.shoestore.entities.inventory;

import com.shoestore.entities.BaseIdEntity;
import com.shoestore.entities.shoe.Shoe;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
public class ShoeInventory  extends BaseIdEntity {

	@OneToOne
	private Shoe shoe;

	@OneToMany
	private List<ShoeAvailability> shoeAvailability;

	public ShoeInventory() {}
	public ShoeInventory(Shoe shoe, List<ShoeAvailability> shoeAvailability) {
		this.shoe = shoe;
		this.shoeAvailability = shoeAvailability;
	}
}
