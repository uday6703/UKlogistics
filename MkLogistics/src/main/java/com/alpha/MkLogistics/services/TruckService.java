package com.alpha.MkLogistics.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alpha.MkLogistics.ResponseStructure;
import com.alpha.MkLogistics.entities.Carrier;
import com.alpha.MkLogistics.entities.Truck;
import com.alpha.MkLogistics.exception.GlobalExceptionHandler;
import com.alpha.MkLogistics.repository.CarrierRepository;
import com.alpha.MkLogistics.repository.TruckRepository;

@Service
public class TruckService {
	
	@Autowired
	private TruckRepository truckRepository;
	
	@Autowired
	private  CarrierRepository carrierRepository;

	public ResponseEntity<ResponseStructure<Truck>> saveTruck(Truck truck,String carrierName) {
		Truck existTruck=truckRepository.findByNumber(truck.getNumber());
		Carrier carrier=carrierRepository.findByName(carrierName);
		if(existTruck!=null) {
			return new GlobalExceptionHandler().truckAlreadyExistException(existTruck);
		}else {
			List<Truck> tlist=Arrays.asList(truck);
			carrier.setTrucks(tlist);
			truck.setCarrier(carrier);
			truckRepository.save(truck);
			ResponseStructure<Truck> rs = new ResponseStructure<Truck>();
			rs.setCode(HttpStatus.OK.value());
			rs.setMessage("Truck Saved Successfully...");
			rs.setData(truck);

			return new ResponseEntity<ResponseStructure<Truck>>(rs, HttpStatus.OK);
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
