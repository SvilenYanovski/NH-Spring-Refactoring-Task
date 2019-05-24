package com.shoestore.rest;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoestore.domain.Order;
import com.shoestore.domain.ShoeInventory;
import com.shoestore.domain.ShoePair;
import com.shoestore.domain.Shopper;
import com.shoestore.repo.OrderRepo;
import com.shoestore.repo.ShoeInventoryRepo;
import com.shoestore.service.ShoeStoreService;

@Service
public class OrderRestService {
	
//	@Autowired
//	private OrderRepo orderRepo;
//	@Autowired
//	private ShoeInventoryRepo inventoryRepo;
//	@Autowired
//	private ShoeStoreService shoeStoreService;
//
//	@GET
//	@Path("orders/{shopperId}")
//	public Order getOrder(@PathParam("shopperId") long shopperId) {
//		Order order = orderRepo.getOrderByShopperId(shopperId);
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
//			Order order = orderRepo.getOrderByShopperId(shopperId);
//			if (order == null) {
//				return null;
//			} else {
//				long errorCode = shoeStoreService.reservePair(inventory, shoePair.getShoeSize());
//				if (errorCode < 0) return null;
//
//				shoeStoreService.addToCart(order, shoePair);
//
//				inventoryRepo.commit(inventory);
//				return orderRepo.commit(order);
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
