package com.alpha.MkLogistics.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.alpha.MkLogistics.entities.Address;

public class LoadingDto {
	private int id;
	private LocalDate date;
	private LocalTime time;

	private Address address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public LoadingDto(LocalDate date, LocalTime time, Address address) {
		this.date = date;
		this.time = time;
		this.address = address;
	}

	public LoadingDto() {
	}
}
