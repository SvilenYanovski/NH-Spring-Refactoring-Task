package com.shoestore.entities.shoe;

import com.shoestore.entities.order.OrderItem;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Data
@Entity
public class ShoePair extends OrderItem {

	@OneToOne
	private Shoe shoe;
	@OneToOne
	private ShoeSize shoeSize;

	public ShoePair() {}
	public ShoePair(Shoe shoe, ShoeSize size) {
		this.shoe = shoe;
		this.shoeSize = size;
	}
}
