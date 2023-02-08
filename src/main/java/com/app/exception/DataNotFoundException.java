package com.app.exception;

@SuppressWarnings("serial")
public class DataNotFoundException extends Exception {
	public DataNotFoundException()
	{
		super();
	}
	public DataNotFoundException(String message)
	{
		super(message);
	}
}
