package com.alpha.MkLogistics.dto;

import com.alpha.MkLogistics.entities.Carrier;
import com.alpha.MkLogistics.entities.Driver;

public class TruckDto {
	private int id;
	private String name;
	private String number;
	private int capacity;
	private String status;

	private Carrier carrier;

	private Driver driver;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public TruckDto(String name, String number, int capacity, String status, Carrier carrier, Driver driver) {
		this.name = name;
		this.number = number;
		this.capacity = capacity;
		this.status = status;
		this.carrier = carrier;
		this.driver = driver;
	}

	public TruckDto() {
	}
}
