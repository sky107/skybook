package com.skybook.skybook.error;

import java.util.Date;
import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions.Include;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice.This;


// no args constructor will make sure proper conversion JSON to response
@Data
@NoArgsConstructor
@JsonInclude(value = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
public class ApiError {
	private long timestamp=new Date().getTime();
	private int status;
	private String message;
	private String url;
	
	
	
	private Map<String, String>validationErrors;
	
	public ApiError(int status, String message, String url) {
		super();
//		this.timestamp = timestamsp;
		this.status = status;
		this.message = message;
		this.url = url;
	}
	
	
	
	
}
