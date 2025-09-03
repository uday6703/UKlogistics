package com.alpha.MkLogistics.entities;

import java.time.LocalDate;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "orders")
public class Order {
	@Id
	private int id;
	private LocalDate orderdate;
	private String status;
	private double cost;

	@ManyToOne
	@JsonIgnoreProperties({"orders","trucks","drivers"})
	private Carrier carrier;

	@ManyToOne
	private Cargo cargo;

	@OneToOne
	private Loading loading;

	@OneToOne
	private Unloading unloading;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(LocalDate orderdate) {
		this.orderdate = orderdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Loading getLoading() {
		return loading;
	}

	public void setLoading(Loading loading) {
		this.loading = loading;
	}

	public Unloading getUnloading() {
		return unloading;
	}

	public void setUnloading(Unloading unloading) {
		this.unloading = unloading;
	}

	public Order(int id,LocalDate orderdate, String status, double cost, Carrier carrier, Cargo cargo, Loading loading,
			Unloading unloading) {
		this.id=id;
		this.orderdate = orderdate;
		this.status = status;
		this.cost = cost;
		this.carrier = carrier;
		this.cargo = cargo;
		this.loading = loading;
		this.unloading = unloading;
	}

	public Order() {
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderdate=" + orderdate + ", status=" + status + ", cost=" + cost + ", carrier="
				+ carrier.getName() + ", cargo=" + cargo + ", loading=" + loading + ", unloading=" + unloading + "]";
	}

}
