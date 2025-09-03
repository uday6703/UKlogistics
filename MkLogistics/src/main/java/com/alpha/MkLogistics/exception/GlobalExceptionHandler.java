package com.alpha.MkLogistics.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alpha.MkLogistics.ResponseStructure;
import com.alpha.MkLogistics.entities.Address;
import com.alpha.MkLogistics.entities.Cargo;
import com.alpha.MkLogistics.entities.Carrier;
import com.alpha.MkLogistics.entities.Driver;
import com.alpha.MkLogistics.entities.Order;
import com.alpha.MkLogistics.entities.Truck;
import com.alpha.MkLogistics.entities.User;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(CarrierAlreadyExistException.class)
	public ResponseEntity<ResponseStructure<Carrier>> carrierAlreadyExistException(Carrier carrier) {
		ResponseStructure<Carrier> rs = new ResponseStructure<Carrier>();
		rs.setCode(HttpStatus.FOUND.value());
		rs.setMessage("Carrier Already Exist...");
		rs.setData(carrier);

		return new ResponseEntity<ResponseStructure<Carrier>>(rs, HttpStatus.FOUND);
	}
	
	@ExceptionHandler(CarrierNotFoundException.class)
	public ResponseEntity<ResponseStructure<Carrier>> carrierNotFoundException() {
		ResponseStructure<Carrier> rs = new ResponseStructure<Carrier>();
		rs.setCode(HttpStatus.NOT_FOUND.value());
		rs.setMessage("Carrier Not Found...");
		rs.setData(null);

		return new ResponseEntity<ResponseStructure<Carrier>>(rs, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CargoAlreadyExistException.class)
	public ResponseEntity<ResponseStructure<Cargo>> cargoAlreadyExistException(Cargo cargo) {
		ResponseStructure<Cargo> rs = new ResponseStructure<Cargo>();
		rs.setCode(HttpStatus.FOUND.value());
		rs.setMessage("Cargo Already Exist...");
		rs.setData(cargo);

		return new ResponseEntity<ResponseStructure<Cargo>>(rs, HttpStatus.FOUND);
	}
	
	@ExceptionHandler(CargoNotFoundException.class)
	public ResponseEntity<ResponseStructure<Cargo>> cargoNotFoundException() {
		ResponseStructure<Cargo> rs = new ResponseStructure<Cargo>();
		rs.setCode(HttpStatus.NOT_FOUND.value());
		rs.setMessage("Cargo Not Found...");
		rs.setData(null);

		return new ResponseEntity<ResponseStructure<Cargo>>(rs, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AddressAlreadyExistException.class)
	public ResponseEntity<ResponseStructure<Address>> addressAlreadyExistException(Address address) {
		ResponseStructure<Address> rs = new ResponseStructure<Address>();
		rs.setCode(HttpStatus.FOUND.value());
		rs.setMessage("Address Already Exist...");
		rs.setData(address);

		return new ResponseEntity<ResponseStructure<Address>>(rs, HttpStatus.FOUND);
	}
	
	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<ResponseStructure<Address>> addressNotFoundException() {
		ResponseStructure<Address> rs = new ResponseStructure<Address>();
		rs.setCode(HttpStatus.NOT_FOUND.value());
		rs.setMessage("Address Not Found...");
		rs.setData(null);

		return new ResponseEntity<ResponseStructure<Address>>(rs, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DriverAlreadyExistException.class)
	public ResponseEntity<ResponseStructure<Driver>> driverAlreadyExistException(Driver driver) {
		ResponseStructure<Driver> rs = new ResponseStructure<Driver>();
		rs.setCode(HttpStatus.FOUND.value());
		rs.setMessage("Driver Already Exist...");
		rs.setData(driver);

		return new ResponseEntity<ResponseStructure<Driver>>(rs, HttpStatus.FOUND);
	}
	
	@ExceptionHandler(DriverNotFoundException.class)
	public ResponseEntity<ResponseStructure<Driver>> driverNotFoundException() {
		ResponseStructure<Driver> rs = new ResponseStructure<Driver>();
		rs.setCode(HttpStatus.NOT_FOUND.value());
		rs.setMessage("Driver Not Found...");
		rs.setData(null);

		return new ResponseEntity<ResponseStructure<Driver>>(rs, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(TruckAlreadyExistException.class)
	public ResponseEntity<ResponseStructure<Truck>> truckAlreadyExistException(Truck truck) {
		ResponseStructure<Truck> rs = new ResponseStructure<Truck>();
		rs.setCode(HttpStatus.FOUND.value());
		rs.setMessage("Truck Already Exist...");
		rs.setData(truck);

		return new ResponseEntity<ResponseStructure<Truck>>(rs, HttpStatus.FOUND);
	}
	
	@ExceptionHandler(TruckNotFoundException.class)
	public ResponseEntity<ResponseStructure<Truck>> truckNotFoundException() {
		ResponseStructure<Truck> rs = new ResponseStructure<Truck>();
		rs.setCode(HttpStatus.NOT_FOUND.value());
		rs.setMessage("Truck Not Found...");
		rs.setData(null);

		return new ResponseEntity<ResponseStructure<Truck>>(rs, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<ResponseStructure<User>> userAlreadyExistException(User user) {
		ResponseStructure<User> rs = new ResponseStructure<User>();
		rs.setCode(HttpStatus.FOUND.value());
		rs.setMessage("User Already Exist...");
		rs.setData(user);

		return new ResponseEntity<ResponseStructure<User>>(rs, HttpStatus.FOUND);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ResponseStructure<User>> userNotFoundException() {
		ResponseStructure<User> rs = new ResponseStructure<User>();
		rs.setCode(HttpStatus.NOT_FOUND.value());
		rs.setMessage("Driver Not Found...");
		rs.setData(null);

		return new ResponseEntity<ResponseStructure<User>>(rs, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<ResponseStructure<Order>> orderNotFoundException() {
		ResponseStructure<Order> rs = new ResponseStructure<Order>();
		rs.setCode(HttpStatus.NOT_FOUND.value());
		rs.setMessage("Order Not Found...");
		rs.setData(null);

		return new ResponseEntity<ResponseStructure<Order>>(rs, HttpStatus.NOT_FOUND);
	}
}
