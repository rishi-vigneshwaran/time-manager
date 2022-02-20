package com.example.demo.model;

import org.springframework.http.HttpStatus;

public class Response {

	private HttpStatus code;
	private String message;	
	private Object object;
	
	public Response() {
		super();
	}
	
	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getCode() {
		return code;
	}
	public void setCode(HttpStatus code) {
		this.code = code;
	}
	
	public Response(String message, HttpStatus code) {
		super();
		this.message = message;
		this.code = code;
	}
	
	@Override
	public String toString() {
		return "Response [message=" + message + ", code=" + code + "]";
	}
	
}
