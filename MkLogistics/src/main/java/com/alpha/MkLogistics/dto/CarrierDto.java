package com.alpha.MkLogistics.dto;

import java.util.List;

import com.alpha.MkLogistics.entities.Driver;
import com.alpha.MkLogistics.entities.Order;
import com.alpha.MkLogistics.entities.Truck;

public class CarrierDto {
	private int id;
	private String name;
	private String mail;
	private String contact;

	private List<Order> orders;

	private List<Truck> trucks;

	private List<Driver> drivers;

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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Truck> getTrucks() {
		return trucks;
	}

	public void setTrucks(List<Truck> trucks) {
		this.trucks = trucks;
	}

	public List<Driver> getDrivers() {
		return drivers;
	}

	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}

	public CarrierDto(String name, String mail, String contact, List<Order> orders, List<Truck> trucks,
			List<Driver> drivers) {
		this.name = name;
		this.mail = mail;
		this.contact = contact;
		this.orders = orders;
		this.trucks = trucks;
		this.drivers = drivers;
	}

	public CarrierDto() {
	}
}
