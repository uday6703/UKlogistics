package com.alpha.MkLogistics.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alpha.MkLogistics.ResponseStructure;
import com.alpha.MkLogistics.entities.Driver;
import com.alpha.MkLogistics.entities.Truck;
import com.alpha.MkLogistics.exception.GlobalExceptionHandler;
import com.alpha.MkLogistics.repository.DriverRepository;
import com.alpha.MkLogistics.repository.TruckRepository;

@Service
public class DriverService {
	@Autowired
	private DriverRepository driverRepository;

	@Autowired
	private TruckRepository truckRepository;

	public ResponseEntity<ResponseStructure<Driver>> saveDriver(Driver driver) {
		Driver existDriver = driverRepository.findByContact(driver.getContact());
		Truck truck = truckRepository.findByNumber(driver.getTruck().getNumber());
		if (existDriver != null) {
			return new GlobalExceptionHandler().driverAlreadyExistException(driver);

		} else {
			driver.setTruck(truck);
			driver.setCarrier(truck.getCarrier());
			truck.setDriver(driver);
			driverRepository.save(driver);
			ResponseStructure<Driver> rs = new ResponseStructure<Driver>();
			rs.setCode(HttpStatus.OK.value());
			rs.setMessage("Driver Saved Successfully...");
			rs.setData(driver);

			return new ResponseEntity<ResponseStructure<Driver>>(rs, HttpStatus.OK);
		}
	}

	public ResponseEntity<ResponseStructure<Driver>> updateDriver(long contact,Driver driver) {
		
			Driver existDriver = driverRepository.findByContact(contact);
			existDriver.setName(driver.getName());
			existDriver.setContact(driver.getContact());
			Driver updatedDriver=driverRepository.save(existDriver);
			ResponseStructure<Driver> rs = new ResponseStructure<Driver>();
			rs.setCode(HttpStatus.OK.value());
			rs.setMessage("Driver Updated Successfully...");
			rs.setData(updatedDriver);

			return new ResponseEntity<ResponseStructure<Driver>>(rs, HttpStatus.OK);

		
	}

	public ResponseEntity<ResponseStructure<Driver>> findDriver(long contact) {
		try {
			Driver driver = driverRepository.findByContact(contact);
			ResponseStructure<Driver> responseStructure = new ResponseStructure<Driver>();
			responseStructure.setCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Driver fetched Successfully");
			responseStructure.setData(driver);
			return new ResponseEntity<ResponseStructure<Driver>>(responseStructure, HttpStatus.OK);
		} catch (Exception e) {
			return new GlobalExceptionHandler().driverNotFoundException();
		}
	}
}
