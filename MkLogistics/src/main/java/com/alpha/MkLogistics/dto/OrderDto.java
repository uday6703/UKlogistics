package com.alpha.MkLogistics.dto;

import java.time.LocalDate;

import com.alpha.MkLogistics.entities.Cargo;
import com.alpha.MkLogistics.entities.Carrier;
import com.alpha.MkLogistics.entities.Loading;
import com.alpha.MkLogistics.entities.Unloading;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

public class OrderDto {
	private int id;
	private LocalDate orderdate;
	private String status;
	private double cost;

	private Carrier carrier;

	private Cargo cargo;

	private Loading loading;

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

	public OrderDto(int id,LocalDate orderdate, String status, double cost, Carrier carrier, Cargo cargo, Loading loading,
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

	public OrderDto() {
	}

}
