package com.alpha.MkLogistics.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Driver {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private long contact;

	@OneToOne
	@JsonIgnoreProperties({"carrier","driver"})
	private Truck truck;

	@ManyToOne
	@JsonIgnoreProperties({"orders","trucks","drivers"})
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

	public Driver(String name, Long contact, Truck truck, Carrier carrier) {
		this.name = name;
		this.contact = contact;
		this.truck = truck;
		this.carrier = carrier;
	}

	public Driver() {
	}

	@Override
	public String toString() {
		return "Driver [id=" + id + ", name=" + name + ", contact=" + contact + ", truck=" + truck.getName()
				+ ", carrier=" + carrier.getName() + "]";
	}

}
