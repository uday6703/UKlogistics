package com.alpha.MkLogistics.dto;

public class CargoDto {
	private int id;
	private String name;
	private String description;
	private double weight;
	private int count;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public CargoDto(int id, String name, String description, double weight, int count) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.weight = weight;
		this.count = count;
	}

	public CargoDto() {
	}
}
