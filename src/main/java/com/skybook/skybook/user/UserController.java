package com.skybook.skybook.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import com.skybook.skybook.error.ApiError;
import com.skybook.skybook.shared.GenericResponse;




//handling http request


@RestController
public class UserController {
		
		// for useconroller we need not to write the test
	// so we can use automwited notaiton
	
	
		@Autowired
		UserService userService;
		
		// with @Valid anotation we are telling Spring to run validation before passing to body , elese Internal Server Error
		@PostMapping("/api/1.0/users")
		GenericResponse createUser(@Valid @RequestBody User user) {

//			System.out.println("HasdfsaIsadf");
//			System.out.println(user);
			
			
			// below is custom Exception throwings, since javabean has inbuild validator which will automatically throw Badrequest we can also use that
			// simply mention in Java Entity
//			if(user.getUsername()==null || user.getDisplayName()==null) {
//				// fix for the test
//				throw new UserNotValidException();
//			}
			
			userService.save(user);
			
//			below can  be more refractored 
//			GenericResponse body=new GenericResponse();
//			body.setMessage("User Saved");
//			return body;
				// controller should not deal with businesss logic
			
			//failing returning java object but jackson, stringy formated in json
			// needs java class construct with no args
			// we can solve by contructor overiding or norgs anoation with lambook
			return new GenericResponse("User saved");
		
		
		
		}
		
		@ExceptionHandler({MethodArgumentNotValidException.class})
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		ApiError handleValidationException(MethodArgumentNotValidException exception,HttpServletRequest request) {
			ApiError apiError=new ApiError(400,"validation error",request.getServletPath());
			
			
			BindingResult result=exception.getBindingResult();
			Map<String, String> validationErrors=new HashMap<>();
			for(FieldError fieldError:result.getFieldErrors()) {
				validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			
			apiError.setValidationErrors(validationErrors);
			
			return apiError;
			
		}
}
