package com.alpha.MkLogistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.MkLogistics.ResponseStructure;
import com.alpha.MkLogistics.entities.Address;
import com.alpha.MkLogistics.entities.Carrier;
import com.alpha.MkLogistics.entities.Driver;
import com.alpha.MkLogistics.entities.Order;
import com.alpha.MkLogistics.entities.Truck;
import com.alpha.MkLogistics.services.AddressService;
import com.alpha.MkLogistics.services.CarrierService;
import com.alpha.MkLogistics.services.DriverService;
import com.alpha.MkLogistics.services.OrderService;
import com.alpha.MkLogistics.services.TruckService;

@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"})
@RestController
public class AdminController {
	@Autowired
	private CarrierService carrierService;

	@Autowired
	private TruckService truckService;

	@Autowired
	private DriverService driverService;

	@Autowired
	private AddressService addressService;

	@Autowired
	private OrderService orderService;

	@PostMapping("/carrier")
	public ResponseEntity<ResponseStructure<Carrier>> saveCarrier(@RequestBody Carrier carrier) {
		return carrierService.saveCarrier(carrier);
	}

	@PostMapping("/truck")
	public ResponseEntity<ResponseStructure<Truck>> saveTruck(@RequestBody Truck truck,
			@RequestParam String carrierName) {
		return truckService.saveTruck(truck, carrierName);
	}

	@PostMapping("/driver")
	public ResponseEntity<ResponseStructure<Driver>> saveDriver(@RequestBody Driver driver) {
		return driverService.saveDriver(driver);
	}

	@GetMapping("/driver")
	public ResponseEntity<ResponseStructure<Driver>> findDriver(@RequestParam long contact) {
		return driverService.findDriver(contact);
	}

	@PutMapping("/driver")
	public ResponseEntity<ResponseStructure<Driver>> updateDriver(@RequestParam long contact,@RequestBody Driver driver) {
		return driverService.updateDriver(contact, driver);
	}

	@PostMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}

	@PutMapping("/order")
	public ResponseEntity<ResponseStructure<Order>> updateOrder(@RequestParam int orderId,
			@RequestParam int unloadingDays) {
		return orderService.updateOrder(orderId, unloadingDays);
	}
}
