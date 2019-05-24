package com.shoestore.controllers;

import com.shoestore.entities.Order;
import com.shoestore.entities.ShoeInventory;
import com.shoestore.entities.ShoePair;
import com.shoestore.repositories.OrderRepository;
import com.shoestore.repositories.ShoeInventoryRepository;
import com.shoestore.repositories.ShopperRepository;
import com.shoestore.services.ShoeStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ShopperRepository shopperRepository;
	@Autowired
	private ShoeInventoryRepository inventoryRepository;
	@Autowired
	private ShoeStoreService shoeStoreService;

	@GetMapping("{shopperId}")
	public Order getOrder(@PathParam("shopperId") long shopperId) {
		Order order = orderRepository.findByShopperId(shopperId);
		if (order != null) return order;
		return new Order(shopperRepository.getOne(shopperId));
	}

	@GetMapping("{shopperId}/total")
	public Double getTotalPrice(@PathParam("shopperId") long shopperId) {
		return orderRepository.findByShopperId(shopperId).getPrice();
	}

	@PutMapping(value = "{shopperId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Order addShoePair(@PathParam("shopperId") long shopperId, ShoePair shoePair) {
		ShoeInventory inventory = inventoryRepository.findByShoeId(shoePair.getModel().getId());
		if (inventory == null) {
			return null;
		} else {
			Order order = orderRepository.findByShopperId(shopperId);
			if (order == null) {
				return null;
			} else {
				long errorCode = shoeStoreService.reservePair(inventory, shoePair.getShoeSize());
				if (errorCode < 0) return null;

				shoeStoreService.addToCart(order, shoePair);

				inventoryRepository.save(inventory);
				return orderRepository.save(order);
			}
		}
	}

	@PostMapping(value = "{shopperId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Order updateShoePair(@PathParam("shopperId") long shopperId, ShoePair shoePair) {
		//IGNORE: to be implemented
		return null;
	}

	@DeleteMapping(value = "{shopperId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Order removeShoePair(@PathParam("shopperId") long shopperId, ShoePair shoePair) {
		//IGNORE: to be implemented
		return null;
	}
	
}
