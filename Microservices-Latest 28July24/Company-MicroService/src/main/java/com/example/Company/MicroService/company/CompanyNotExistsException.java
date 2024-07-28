package com.example.Company.MicroService.company;

public class CompanyNotExistsException extends RuntimeException {
	
	public CompanyNotExistsException(String msg)
	{
		super(msg);
	}

}
