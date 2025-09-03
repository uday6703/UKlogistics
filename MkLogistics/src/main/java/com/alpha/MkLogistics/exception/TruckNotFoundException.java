package com.alpha.MkLogistics.exception;

public class TruckNotFoundException extends RuntimeException{
	public TruckNotFoundException(String msg) {
		super(msg);
	}
}
