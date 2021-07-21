/**
 * 
 */
package com.am.demo.exception;

import java.util.Date;

/**
 * @author sbiswas
 *
 */


public class DemoExceptionResponse {

	private Date timeStamp;
	private String message;
	private String details;
	
	public DemoExceptionResponse(Date timeStamp, String message, String details) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
}
