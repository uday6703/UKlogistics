package com.alpha.MkLogistics.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Truck {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String number;
	private int capacity;
	private String status;

	@ManyToOne
	@JsonIgnoreProperties({"orders","trucks","drivers"})
	private Carrier carrier;

	@OneToOne
	@JsonIgnoreProperties({"truck","carrier"})
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

	public Truck(String name, String number, int capacity, String status, Carrier carrier, Driver driver) {
		this.name = name;
		this.number = number;
		this.capacity = capacity;
		this.status = status;
		this.carrier = carrier;
		this.driver = driver;
	}

	public Truck() {
	}

	@Override
	public String toString() {
		return "Truck [id=" + id + ", name=" + name + ", number=" + number + ", capacity=" + capacity + ", status="
				+ status + ", carrier=" + carrier.getName() + ", driver=" + driver.getName() + "]";
	}
}
