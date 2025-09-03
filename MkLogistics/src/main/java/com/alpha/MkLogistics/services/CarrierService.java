package com.alpha.MkLogistics.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alpha.MkLogistics.ResponseStructure;
import com.alpha.MkLogistics.entities.Carrier;
import com.alpha.MkLogistics.exception.GlobalExceptionHandler;
import com.alpha.MkLogistics.repository.CarrierRepository;

@Service
public class CarrierService {
	@Autowired
	private CarrierRepository carrierRepository;

	public ResponseEntity<ResponseStructure<Carrier>> saveCarrier(Carrier carrier) {
		Carrier existCarrier = carrierRepository.findByName(carrier.getName());
		if (existCarrier!=null) {
			return new GlobalExceptionHandler().carrierAlreadyExistException(carrier);

		} else {
			carrierRepository.save(carrier);
			ResponseStructure<Carrier> rs = new ResponseStructure<Carrier>();
			rs.setCode(HttpStatus.OK.value());
			rs.setMessage("Carrier Saved Successfully...");
			rs.setData(carrier);

			return new ResponseEntity<ResponseStructure<Carrier>>(rs, HttpStatus.OK);
		}
	}

//	public ResponseEntity<ResponseStructure<Carrier>> updateCarrier(Carrier carrier) {
//		Optional<Carrier> existCarrier = carrierRepository.findById(carrier.getId());
//		if (existCarrier.isPresent()) {
//			carrierRepository.save(carrier);
//			ResponseStructure<Carrier> rs = new ResponseStructure<Carrier>();
//			rs.setCode(HttpStatus.OK.value());
//			rs.setMessage("Carrier Updated Successfully...");
//			rs.setData(carrier);
//
//			return new ResponseEntity<ResponseStructure<Carrier>>(rs, HttpStatus.OK);
//		} else {
//			return new GlobalExceptionHandler().carrierNotFoundException();
//		}
//	}

	public ResponseEntity<ResponseStructure<Carrier>> findCarrier(int id) {
		Optional<Carrier> carrier = carrierRepository.findById(id);
		if (carrier.isPresent()) {
			ResponseStructure<Carrier> rs = new ResponseStructure<Carrier>();
			rs.setCode(HttpStatus.FOUND.value());
			rs.setMessage("Carrier Fetched Successfully...");
			rs.setData(carrier.get());

			return new ResponseEntity<ResponseStructure<Carrier>>(rs, HttpStatus.OK);
		} else {
			return new GlobalExceptionHandler().carrierNotFoundException();
		}
	}
}
