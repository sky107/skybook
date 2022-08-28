package com.skybook.skybook;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.skybook.skybook.error.ApiError;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class LoginControllerTest {
	
	private static final String API_1_0_LOGIN="/api/1.0/login";
	
	@Autowired
	TestRestTemplate testRestTemplate;
	
	@Test
	public void postLogin_WithoutUserCredentials_receiveUnauthorized() {
		ResponseEntity<Object> response=login(Object.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
	}
	
	@Test
	public void postLogin_WithoutUserCredentials_receiveUnauthorizedWithoutValidationError() {
		ResponseEntity<String> response=login(String.class);
		assertThat(response.getBody().contains("validationErrors")).isFalse();
		// in ApiError file add something 
	}
	
	@Test
	public void postLogin_WithoutUserCredentials_receiveUnauthorizedWithoutWWWAuthenticationHeader() {
		ResponseEntity<Object> response=login(Object.class);
		assertThat(response.getHeaders().containsKey("WWW-Authenticate")).isFalse();
		// in security configuration
	
	
	public void authenticate() {
		testRestTemplate.getRestTemplate().getInterceptors().add(new BasicAuthenticationInterceptor("test-username", "test-p4wd"));
	}
	
	@Test
	public void postLogin_WithIncorrectUserCredentials_receiveUnauthorized() {
		authenticate();
		ResponseEntity<Object> response=login(Object.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
	}
	
	
	@Test
	public void postLogin_WithIncorrectUserCredential_receiveApiError() {
		ResponseEntity<ApiError> response=login(ApiError.class);
		assertThat(response.getBody().getUrl()).isEqualTo(API_1_0_LOGIN);
		// remember that until you'll add a custom address springboot will add defualt message
		// similar for validationException add new @ in controller
		
	}
	
	public<T>ResponseEntity<T> login(Class<T> responseType){
		return testRestTemplate.postForEntity(API_1_0_LOGIN, null, responseType);
	}

}
