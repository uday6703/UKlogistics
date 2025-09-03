package com.alpha.MkLogistics.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alpha.MkLogistics.ResponseStructure;
import com.alpha.MkLogistics.dto.OrderDto;
import com.alpha.MkLogistics.entities.Address;
import com.alpha.MkLogistics.entities.Cargo;
import com.alpha.MkLogistics.entities.Carrier;
import com.alpha.MkLogistics.entities.Loading;
import com.alpha.MkLogistics.entities.Order;
import com.alpha.MkLogistics.entities.Unloading;
import com.alpha.MkLogistics.exception.*;
import com.alpha.MkLogistics.repository.AddressRepository;
import com.alpha.MkLogistics.repository.CargoRepository;
import com.alpha.MkLogistics.repository.CarrierRepository;
import com.alpha.MkLogistics.repository.LoadingRepository;
import com.alpha.MkLogistics.repository.OrderRepository;
import com.alpha.MkLogistics.repository.UnloadingRepository;
import com.alpha.MkLogistics.exception.GlobalExceptionHandler;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private CargoRepository cargoRepo;

	@Autowired
	private CarrierRepository carrierRepo;

	@Autowired
	private AddressRepository addressRepo;

	@Autowired
	private LoadingRepository loadingRepo;

	@Autowired
	private UnloadingRepository unloadingRepo;

	public ResponseEntity<ResponseStructure<Order>> saveOrder(OrderDto orderDto) {

		Cargo cargo = cargoRepo.findById(orderDto.getCargo().getId()).get();

		Carrier carrier = carrierRepo.findByName(orderDto.getCarrier().getName());

		Address loadingAddress = addressRepo.findById(orderDto.getLoading().getAddress().getId()).get();

		// Loading
		Loading loading = new Loading();
		loading.setAddress(loadingAddress);

		// date
		LocalDate loadingDate = LocalDate.now();
		loading.setDate(loadingDate);

		// time
		LocalTime loadingTime = LocalTime.now();
		loading.setTime(loadingTime);
		loadingRepo.save(loading);

		// Unloading
		Address unloadingAddress = addressRepo.findById(orderDto.getUnloading().getAddress().getId()).get();
		Unloading unloading = new Unloading();
		unloading.setAddress(unloadingAddress);
		unloadingRepo.save(unloading);

		// Order
		Order order = new Order();
		order.setId(orderDto.getId());
		order.setOrderdate(loadingDate);
		order.setStatus("Pending");
		order.setCargo(cargo);
		order.setCarrier(carrier);
		order.setLoading(loading);
		order.setUnloading(unloading);

		// list of orders to carrier
		Order updatedOrder = orderRepo.save(order);

		carrier.getOrders().add(updatedOrder);
		carrierRepo.save(carrier);

		ResponseStructure<Order> responseStructure = new ResponseStructure<Order>();
		responseStructure.setCode(HttpStatus.ACCEPTED.value());
		responseStructure.setMessage("Your Order Pending at Admin...");
		responseStructure.setData(updatedOrder);
		return new ResponseEntity<ResponseStructure<Order>>(responseStructure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Order>> updateOrder(int id, int unloadingDays) {
		try {
			Order order = orderRepo.findById(id).get();
			if (order.getStatus().equals("Pending")) {
				order.setStatus("Placed");

				// cost calculation
				double weight = order.getCargo().getWeight();
				int count = order.getCargo().getCount();
				double cost = 100 * (weight * count);

				order.setCost(cost);

				LocalDate loadingDate = order.getLoading().getDate();
				order.getUnloading().setDate(loadingDate.plusDays(unloadingDays));

				Order updatedOrder = orderRepo.save(order);

				ResponseStructure<Order> responseStructure = new ResponseStructure<Order>();
				responseStructure.setCode(HttpStatus.OK.value());
				responseStructure.setMessage("Your Order Placed Successfully...");
				responseStructure.setData(updatedOrder);
				return new ResponseEntity<ResponseStructure<Order>>(responseStructure, HttpStatus.OK);
			} else if (order.getStatus().equals("Placed")) {
				order.setStatus("Completed");

				LocalTime time = LocalTime.now();
				order.getUnloading().setTime(time);

				Order updatedOrder = orderRepo.save(order);
				ResponseStructure<Order> responseStructure = new ResponseStructure<Order>();
				responseStructure.setCode(HttpStatus.OK.value());
				responseStructure.setMessage("Your Order Completed Successfully...");
				responseStructure.setData(updatedOrder);
				return new ResponseEntity<ResponseStructure<Order>>(responseStructure, HttpStatus.OK);
			} else {
				ResponseStructure<Order> responseStructure = new ResponseStructure<Order>();
				responseStructure.setCode(HttpStatus.OK.value());
				responseStructure.setMessage("Your Order already Completed...");
				responseStructure.setData(order);
				return new ResponseEntity<ResponseStructure<Order>>(responseStructure, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new GlobalExceptionHandler().orderNotFoundException();
		}
	}
}
