package com.thriftygoat.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseFormat<T> {

	private T data; 
	private String messsage;
	
	public ResponseFormat() {}
	
	public ResponseFormat(T data, String messsage) {

		this.data = data;
		this.messsage = messsage;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMesssage() {
		return messsage;
	}

	public void setMesssage(String messsage) {
		this.messsage = messsage;
	}
	
	public ResponseEntity<ResponseFormat<T>> createOkResponse(T usedObject) {
		ResponseFormat<T> response = new ResponseFormat<T>();
		response.setData(usedObject);
		return ResponseEntity.status(HttpStatus.OK).body(response); 
	}
	
	public ResponseEntity<ResponseFormat<T>> createBadRequestResponse(String message) {
	    ResponseFormat<T> response = new ResponseFormat<T>();
	    response.setMesssage(message);
	    return ResponseEntity.badRequest().body(response);
	}

	public ResponseEntity<ResponseFormat<T>> createNotFoundResponse(String message) {
	    ResponseFormat<T> response = new ResponseFormat<T>();
	    response.setMesssage(message);
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	public ResponseEntity<ResponseFormat<T>> createInternalServerErrorResponse(String message) {
	    ResponseFormat<T> response = new ResponseFormat<T>();
	    response.setMesssage(message);
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
	
}
