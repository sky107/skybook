package com.skybook.skybook.user;

import java.nio.file.AccessDeniedException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.skybook.skybook.error.ApiError;

@RestController
public class LoginController {
	
	@PostMapping("/api/1.0/login")
	void handleLogin() {
		
	}
	
	
// this will not work as conroller tak aya hi nhi control add a new class which extends ErrorController
//	@ExceptionHandler({AccessDeniedException.class})
//	@ResponseStatus(HttpStatus.UNAUTHORIZED)
//	ApiError handleAccessDeniedException() {
//		return new ApiError(401,"Access Error","/api/1.0/login");
//	}
//	
	
	
}
