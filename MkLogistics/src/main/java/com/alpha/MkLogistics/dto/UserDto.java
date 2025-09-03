package com.alpha.MkLogistics.dto;

public class UserDto {
	private int id;
	private String name;
	private String mail;
	private String role;

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserDto(String name, String mail, String role) {
		this.name = name;
		this.mail = mail;
		this.role = role;
	}

	public UserDto() {
	}
}
