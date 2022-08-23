package com.skybook.skybook;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
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
		
		ResponseEntity<Object> response = testRestTemplate.postForEntity(API_1_0_USERS, user, Object.class);
		
		//assertion
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		// running test is failing
		// create a controller
		
	}
	
	@Test
	public void postUser_whenUserIsValid_receiveSuccessMessage() {
		// failing so we have need to create User class
		User user = createValidUser();
		
		ResponseEntity<GenericResponse> response = testRestTemplate.postForEntity(API_1_0_USERS, user, GenericResponse.class);
		
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
		user.setPassword("password1");
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
}
