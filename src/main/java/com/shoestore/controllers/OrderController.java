package com.shoestore.controllers;

import com.shoestore.repositories.OrderRepository;
import com.shoestore.repositories.ShoeRepository;
import com.shoestore.services.ShoeStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ShoeRepository shoeRepository;
	@Autowired
	private ShoeStoreService shoeStoreService;

//	@GET
//	@Path("orders/{shopperId}")
//	public Order getOrder(@PathParam("shopperId") long shopperId) {
//		Order order = orderRepository.getOrderByShopperId(shopperId);
//		if (order != null) return order;
//		return new Order(new Shopper(shopperId));
//	}
//
//	@GET
//	@Path("orders/{shopperId}")
//	public Double getTotalPrice(@PathParam("shopperId") long shopperId) {
//		//TODO: REST call should be implemented to return the total price of an order
//		return new Double(0);
//	}
//
//	@PUT
//	@Path("orders/{shopperId}")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Order addShoePair(@PathParam("shopperId") long shopperId, ShoePair shoePair) {
//		ShoeInventory inventory = inventoryRepo.getShoeInventoryByShoeModel(shoePair.getModel());
//		if (inventory == null) {
//			return null;
//		} else {
//			Order order = orderRepository.getOrderByShopperId(shopperId);
//			if (order == null) {
//				return null;
//			} else {
//				long errorCode = shoeStoreService.reservePair(inventory, shoePair.getShoeSize());
//				if (errorCode < 0) return null;
//
//				shoeStoreService.addToCart(order, shoePair);
//
//				inventoryRepo.commit(inventory);
//				return orderRepository.commit(order);
//			}
//		}
//	}
//
//	@POST
//	@Path("orders/{shopperId}")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Order updateShoePair(@PathParam("shopperId") long shopperId, ShoePair shoePair) {
//		//IGNORE: to be implemented
//		return null;
//	}
//
//	@DELETE
//	@Path("orders/{shopperId}")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Order removeShoePair(@PathParam("shopperId") long shopperId, ShoePair shoePair) {
//		//IGNORE: to be implemented
//		return null;
//	}
	
}
