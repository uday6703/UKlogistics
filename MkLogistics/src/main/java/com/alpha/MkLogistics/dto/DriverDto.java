package com.alpha.MkLogistics.dto;

import com.alpha.MkLogistics.entities.Carrier;
import com.alpha.MkLogistics.entities.Truck;

public class DriverDto {
	private int id;
	private String name;
	private long contact;

	private Truck truck;

	private Carrier carrier;

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

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public Truck getTruck() {
		return truck;
	}

	public void setTruck(Truck truck) {
		this.truck = truck;
	}

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	public DriverDto(String name, Long contact, Truck truck, Carrier carrier) {
		this.name = name;
		this.contact = contact;
		this.truck = truck;
		this.carrier = carrier;
	}

	public DriverDto() {
	}
}
