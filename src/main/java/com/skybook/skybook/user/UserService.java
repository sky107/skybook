package com.skybook.skybook.user;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


// telling spring  to create instance

@Service
public class UserService {
	
	UserRepository userRepository;
	
	// not working with springboot sercurity
//	@Autowired private static BCryptPasswordEncoder passwordEncoder;
	
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	
	// automatically spring will create a class and assing repostiroy linkage
	// advantage of construcr is if we want to write test for userservice we can
	// contructor injection makes class easy to test
	
	
	public User save(User user) {
		System.out.println("HSDFSDFD");
		System.out.println(user);
		
		user.setPassword((user.getPassword())+1);
		return userRepository.save(user);
	}
}
