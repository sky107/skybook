package com.skybook.skybook.error;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;


// no args constructor will make sure proper conversion JSON to response
@Data
@NoArgsConstructor
public class ApiError {
	private long timestamp=new Date().getTime();
	private int status;
	private String message;
	private String url;
	public ApiError(long timestamp, int status, String message, String url) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.message = message;
		this.url = url;
	}
	
	
}
