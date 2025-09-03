package com.alpha.MkLogistics.exception;

public class TruckAlreadyExistException extends RuntimeException{
	public TruckAlreadyExistException(String msg) {
		super(msg);
	}
}
