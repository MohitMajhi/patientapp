package com.app.exception;

@SuppressWarnings("serial")
public class WrongDataException extends Exception {
	public WrongDataException()
	{
		super();
	}
	public WrongDataException(String message)
	{
		super(message);
	}
}
