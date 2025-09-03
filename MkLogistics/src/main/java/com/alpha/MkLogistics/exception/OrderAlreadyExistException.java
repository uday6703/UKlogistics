package com.alpha.MkLogistics.exception;

public class OrderAlreadyExistException extends RuntimeException{
	public OrderAlreadyExistException(String msg) {
		super(msg);
	}
}
