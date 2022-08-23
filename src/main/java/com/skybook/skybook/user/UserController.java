package com.skybook.skybook.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skybook.skybook.shared.GenericResponse;




//handling http request


@RestController
public class UserController {
		
		// for useconroller we need not to write the test
	// so we can use automwited notaiton
	
	
		@Autowired
		UserService userService;
		
		@PostMapping("/api/1.0/users")
		GenericResponse createUser(@RequestBody User user) {

//			System.out.println("HasdfsaIsadf");
//			System.out.println(user);
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
}
