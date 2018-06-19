package com.example.demo.exception;

import java.util.Date;

//import org.joda.time.DateTime;

public class ApiExceptionDetails {
	
	private Date timestamp;
	
	private String status;
	
	private String error;

	private String message;
	
	public ApiExceptionDetails(Date timestamp,String status,String error,String msg){
		this.message = msg;
		this.status=status;
		this.error=error;
		this.timestamp= timestamp;
	}
	
	public String getMessage() {
		return message;
	}
 
	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
