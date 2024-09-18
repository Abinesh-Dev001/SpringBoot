package com.example.demo.ExceptionHandling;

public class UserNotAvailable extends Exception
{
	public UserNotAvailable(String Message)
	{
		super(Message);
	}
}
