package com.example.Job.MicroService.job;

public class JobNotExistsException extends RuntimeException {
	public JobNotExistsException(String msg) {
		super(msg);
	}
}
