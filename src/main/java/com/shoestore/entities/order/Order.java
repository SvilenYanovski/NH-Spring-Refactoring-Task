package com.shoestore.entities.order;

import com.shoestore.entities.BaseIdEntity;
import com.shoestore.entities.shopper.Shopper;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Order extends BaseIdEntity {

	@ManyToOne
	private Shopper shopper;
	@OneToMany
	private List<OrderItem> items;
	private OrderStatus status;
	private long version = 0l;
	private Double price = null;

	public  Order() {}
	public Order(Shopper shopper) {
		this.shopper = shopper;
		this.status = OrderStatus.SHOPPING_CART;
		this.items = new ArrayList<>();
	}
}
