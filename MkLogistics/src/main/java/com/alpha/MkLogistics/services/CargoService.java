package com.alpha.MkLogistics.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alpha.MkLogistics.ResponseStructure;
import com.alpha.MkLogistics.entities.Cargo;
import com.alpha.MkLogistics.exception.GlobalExceptionHandler;
import com.alpha.MkLogistics.repository.CargoRepository;

@Service
public class CargoService {
	@Autowired
	private CargoRepository cargoRepository;

	public ResponseEntity<ResponseStructure<Cargo>> saveCarrier(Cargo cargo) {
		Optional<Cargo> existCargo = cargoRepository.findById(cargo.getId());
		if (existCargo.isPresent()) {
			return new GlobalExceptionHandler().cargoAlreadyExistException(cargo);

		} else {
			cargoRepository.save(cargo);
			ResponseStructure<Cargo> rs = new ResponseStructure<Cargo>();
			rs.setCode(HttpStatus.OK.value());
			rs.setMessage("Cargo Saved Successfully...");
			rs.setData(cargo);

			return new ResponseEntity<ResponseStructure<Cargo>>(rs, HttpStatus.OK);
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
//
//	public ResponseEntity<ResponseStructure<Carrier>> findCarrier(int id) {
//		Optional<Carrier> carrier = carrierRepository.findById(id);
//		if (carrier.isPresent()) {
//			ResponseStructure<Carrier> rs = new ResponseStructure<Carrier>();
//			rs.setCode(HttpStatus.FOUND.value());
//			rs.setMessage("Carrier Fetched Successfully...");
//			rs.setData(carrier.get());
//
//			return new ResponseEntity<ResponseStructure<Carrier>>(rs, HttpStatus.OK);
//		} else {
//			return new GlobalExceptionHandler().carrierNotFoundException();
//		}
//	}
}
