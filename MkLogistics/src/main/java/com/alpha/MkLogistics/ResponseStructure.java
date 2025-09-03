package com.alpha.MkLogistics;

public class ResponseStructure<T> {
	private int code;
	private String message;
	private T data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public ResponseStructure(int code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public ResponseStructure() {

	}

	@Override
	public String toString() {
		return "Response [code=" + code + ", message=" + message + ", data=" + data + "]";
	}
}
