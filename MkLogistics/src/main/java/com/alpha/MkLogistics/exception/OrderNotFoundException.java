package com.alpha.MkLogistics.exception;

public class OrderNotFoundException extends RuntimeException{
	public OrderNotFoundException(String msg) {
		super(msg);
	}
}
