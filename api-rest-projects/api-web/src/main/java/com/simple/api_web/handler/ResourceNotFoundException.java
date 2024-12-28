package com.simple.api_web.handler;

public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException(String message){
		super(message);
	}
}