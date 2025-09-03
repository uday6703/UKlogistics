package com.alpha.MkLogistics.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Carrier {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String mail;
	private String contact;

	@OneToMany
	@JsonIgnoreProperties({"carrier","cargo","loading","unloading"})
	private List<Order> orders;

	@OneToMany
	@JsonIgnoreProperties({"carrier","driver"})
	private List<Truck> trucks;

	@OneToMany
	@JsonIgnoreProperties({"truck","carrier"})
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

	public Carrier(String name, String mail, String contact, List<Order> orders, List<Truck> trucks,
			List<Driver> drivers) {
		super();
		this.name = name;
		this.mail = mail;
		this.contact = contact;
		this.orders = orders;
		this.trucks = trucks;
		this.drivers = drivers;
	}

	public Carrier() {
	}

	@Override
	public String toString() {
		return "Carrier [id=" + id + ", name=" + name + ", mail=" + mail + ", contact=" + contact + ", orders=" + orders
				+ ", trucks=" + trucks + "]";
	}

}
