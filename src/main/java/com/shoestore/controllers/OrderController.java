package com.shoestore.controllers;

import com.shoestore.entities.order.Order;
import com.shoestore.entities.shoe.ShoePair;
import com.shoestore.services.OrderService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/order")
public class OrderController {

	private final OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping("{shopperId}")
	public Order getOrder(@PathParam("shopperId") long shopperId) {
		return orderService.getOrder(shopperId);
	}

	@GetMapping("{shopperId}/total")
	public Double getTotalPrice(@PathParam("shopperId") long shopperId) {
		return orderService.getTotalPrice(shopperId);
	}

	@PutMapping(value = "{shopperId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Order addShoePair(@PathParam("shopperId") long shopperId, ShoePair shoePair) {
		return orderService.addShoePair(shopperId, shoePair);
	}

	@PostMapping(value = "{shopperId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Order updateShoePair(@PathParam("shopperId") long shopperId, ShoePair shoePair) {
		return orderService.updateShoePair(shopperId, shoePair);
	}

	@DeleteMapping(value = "{shopperId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Order removeShoePair(@PathParam("shopperId") long shopperId, ShoePair shoePair) {
		return orderService.removeShoePair(shopperId, shoePair);
	}
}
