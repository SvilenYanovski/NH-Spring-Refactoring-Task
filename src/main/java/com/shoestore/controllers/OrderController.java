package com.shoestore.controllers;

import com.shoestore.dto.GenericResponseDTO;
import com.shoestore.dto.OrderDTO;
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
	public OrderDTO getOrder(@PathParam("shopperId") long shopperId) {
		return orderService.getOrder(shopperId);
	}

	@GetMapping("{shopperId}/total")
	public GenericResponseDTO getTotalPrice(@PathParam("shopperId") long shopperId) {
		return orderService.getTotalPrice(shopperId);
	}

	@PutMapping(value = "{shopperId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public OrderDTO addShoePair(@PathParam("shopperId") long shopperId, ShoePair shoePair) {
		return orderService.addShoePair(shopperId, shoePair);
	}

	@PostMapping(value = "{shopperId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public OrderDTO updateShoePair(@PathParam("shopperId") long shopperId, ShoePair shoePair) {
		return orderService.updateShoePair(shopperId, shoePair);
	}

	@DeleteMapping(value = "{shopperId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public OrderDTO removeShoePair(@PathParam("shopperId") long shopperId, ShoePair shoePair) {
		return orderService.removeShoePair(shopperId, shoePair);
	}
}
