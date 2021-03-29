package com.example.demo.services.exceptions;


public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) { //PASSANDO O OBJ DO ID QUE FOI TENTADO ENCONTRAR
		super("Resource not found. Id " + id);
	}
}
