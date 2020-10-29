package com.cg.fms.exceptions;

public class InvalidLoginException extends RuntimeException{
	
	private static final long serialVersionUID = 1L; //To ensure that during deserialization the same class is loaded

	public InvalidLoginException(String msg)
	{
		super(msg);
	}

}
