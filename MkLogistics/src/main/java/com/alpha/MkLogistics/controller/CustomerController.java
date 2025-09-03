package com.alpha.MkLogistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.MkLogistics.ResponseStructure;
import com.alpha.MkLogistics.dto.OrderDto;
import com.alpha.MkLogistics.entities.Cargo;
import com.alpha.MkLogistics.entities.Order;
import com.alpha.MkLogistics.services.CargoService;
import com.alpha.MkLogistics.services.OrderService;

@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"})
@RestController
public class CustomerController {
	@Autowired
	private CargoService cargoService;

	@Autowired
	private OrderService orderService;

	@PostMapping("/cargo")
	public ResponseEntity<ResponseStructure<Cargo>> saveCargo(@RequestBody Cargo cargo) {
		return cargoService.saveCarrier(cargo);
	}

	@PostMapping("/order")
	public ResponseEntity<ResponseStructure<Order>> saveOrder(@RequestBody OrderDto orderDto) {
		return orderService.saveOrder(orderDto);
	}
}
