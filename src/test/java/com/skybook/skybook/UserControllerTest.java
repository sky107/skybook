package com.skybook.skybook;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.*;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.skybook.skybook.error.ApiError;
import com.skybook.skybook.shared.GenericResponse;
import com.skybook.skybook.user.User;
import com.skybook.skybook.user.UserRepository;


// Integration Testing

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserControllerTest {
		// defining as test profiles
		// naming methodName_condition_expectedBehaviour
	
	
	// code refracting
	public <T> ResponseEntity<T> postSignUp(Object request,Class<T> response){
		return testRestTemplate.postForEntity(API_1_0_USERS, request, response);
	}
	// field injection
	private static final String API_1_0_USERS = "/api/1.0/users";
	@Autowired
	TestRestTemplate testRestTemplate;
	
	// inject into 
	
	@Autowired
	UserRepository userRepository;
	
	@Before
	public void cleanUp() {
		userRepository.deleteAll();
	}
	
	@Test
	public void postUser_whenUserIsValid_receiveOk() {
		// failing so we have need to create User class
		User user = createValidUser();
		
		ResponseEntity<Object> response = postSignUp( user, Object.class);
		
		//assertion
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		// running test is failing
		// create a controller
		
	}
	
	@Test
	public void postUser_whenUserIsValid_receiveSuccessMessage() {
		// failing so we have need to create User class
		User user = createValidUser();
		
		ResponseEntity<GenericResponse> response = postSignUp(user, GenericResponse.class);
		
		//assertion
		assertThat(response.getBody().getMessage()).isNotNull();
		
		// running test is failing
		// create a controller
		
	}
	
	@Test
	public void postUser_whenUserIsValid_passwordIsHashedInDatabase() {
		// failing so we have need to create User class
		User user = createValidUser();
		
		testRestTemplate.postForEntity(API_1_0_USERS, user, GenericResponse.class);
		
		List<User> users=userRepository.findAll();
		
		User inDB=users.get(0);
		assertThat(inDB.getPassword()).isNotEqualTo(user.getPassword());
		//fail
		// uncomment securiyt still you will get because security headers not passed
		
	}


	private User createValidUser() {
		User user=new User();
		user.setUsername("test-user");
		user.setDisplayName("test-display");
		user.setPassword("Trail@1238");
		return user;
	}
	
	
	
	// we can test multiple assertion in single function but best practices single
	@Test
	public void postUser_whenUserIsValid_userSavedToDatabase() {
			
		User user=createValidUser();

		testRestTemplate.postForEntity(API_1_0_USERS, user, Object.class);
	
		
		// need to transform user class to repositroy using anootation
		assertThat(userRepository.count()).isEqualTo(1);
		// now run it still fail becuase repsotiry is created but not used
		
		// after test is complete return back to original State TDD
	}
	
	
	
	@Test
	public void postUser_whenNullUsername_receiveBadRequest() {
		User user=createValidUser();
		user.setUsername(null);
		ResponseEntity<Object> response = postSignUp(user, Object.class);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	}
	
	@Test
	public void postUser_whenNullDisplayName_receiveBadRequest() {
		User user=createValidUser();
		user.setDisplayName(null);
		ResponseEntity<Object> response = postSignUp(user, Object.class);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	}
	
	@Test
	public void postUser_whenUsernameLessThanRequired_receiveBadRequest() {
		User user=createValidUser();
		user.setUsername("test-username");
		System.out.println(user);
		ResponseEntity<Object> response = postSignUp(user, Object.class);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
		
	}
	
	@Test
	public void postUser_whenThePasswordNotCorrectFormat_receiveBadRequest() {
		User user=createValidUser();
		user.setPassword("Test");
		// uncomment belwo to faill the test
//		user.setPassword("Test@123123123");
		System.out.println(user);
		ResponseEntity<Object> response = postSignUp(user, Object.class);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
		
	}
	
	@Test
	public void postUser_whenTheUserIsInvalid_receiveApiErrors() {
		User user=new User();
		ResponseEntity<ApiError> response = postSignUp(user,ApiError.class);
		assertThat(response.getBody().getUrl()).isEqualTo(API_1_0_USERS);
}
	
	@Test
	public void postUser_whenTheUserIsInvalid_receiveApiErrorsWithValidationErrors() {
		User user=new User();
		ResponseEntity<ApiError> response = postSignUp(user,ApiError.class);
		assertThat(response.getBody().getValidationErrors().size()).isEqualTo(3);
}
	
	@Test
	public void postUser_whenTheUserIsInvalid_receiveMessageOfNullErrorForUsername() {
		User user=new User();
		ResponseEntity<ApiError> response = postSignUp(user,ApiError.class);
		Map<String, String>validationErrors=response.getBody().getValidationErrors();
		
		assertThat(response.getBody().getValidationErrors().get("username")).isEqualTo("Username cannot be a null value");
		
}

	
	
// TODO - Constraint
//	@Test
//	public void postUser_UsernameAlreadyExists_receiveBadRequest() {
//	
//		userRepository.save(createValidUser());
//		
//		// create new again
//		User newUser=createValidUser();
//		ResponseEntity<Object> response= postSignUp(newUser, Object.class);
//
//		
//		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
//}
//	
	
	

	
	
	
	
	
	
	
	
	
	
}
