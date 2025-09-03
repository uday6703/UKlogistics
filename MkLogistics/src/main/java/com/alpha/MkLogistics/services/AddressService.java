package com.alpha.MkLogistics.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alpha.MkLogistics.ResponseStructure;
import com.alpha.MkLogistics.entities.Address;
import com.alpha.MkLogistics.entities.Carrier;
import com.alpha.MkLogistics.exception.GlobalExceptionHandler;
import com.alpha.MkLogistics.repository.CarrierRepository;
import com.alpha.MkLogistics.repository.AddressRepository;

@Service
public class AddressService {
	@Autowired
	private AddressRepository AddressRepository;

	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		Optional<Address> existAddress = AddressRepository.findById(address.getId());
		if (existAddress.isPresent()) {
			return new GlobalExceptionHandler().addressAlreadyExistException(address);

		} else {
			AddressRepository.save(address);
			ResponseStructure<Address> rs = new ResponseStructure<Address>();
			rs.setCode(HttpStatus.OK.value());
			rs.setMessage("Address Saved Successfully...");
			rs.setData(address);

			return new ResponseEntity<ResponseStructure<Address>>(rs, HttpStatus.OK);
		}
	}

//	public ResponseEntity<ResponseStructure<Address>> updateCarrier(Address Address) {
//		Optional<Address> existAddress = AddressRepository.findById(Address.getId());
//		if (existAddress.isPresent()) {
//			AddressRepository.save(Address);
//			ResponseStructure<Address> rs = new ResponseStructure<Address>();
//			rs.setCode(HttpStatus.OK.value());
//			rs.setMessage("Address Updated Successfully...");
//			rs.setData(Address);
//
//			return new ResponseEntity<ResponseStructure<Address>>(rs, HttpStatus.OK);
//		} else {
//			return new GlobalExceptionHandler().addressNotFoundException();
//		}
//	}
//
//	public ResponseEntity<ResponseStructure<Address>> findAddress(int id) {
//		Optional<Address> Address = addressRepository.findById(id);
//		if (Address.isPresent()) {
//			ResponseStructure<Address> rs = new ResponseStructure<Address>();
//			rs.setCode(HttpStatus.FOUND.value());
//			rs.setMessage("Address Fetched Successfully...");
//			rs.setData(Address.get());
//
//			return new ResponseEntity<ResponseStructure<Address>>(rs, HttpStatus.OK);
//		} else {
//			return new GlobalExceptionHandler().addressNotFoundException();
//		}
//	}
}
