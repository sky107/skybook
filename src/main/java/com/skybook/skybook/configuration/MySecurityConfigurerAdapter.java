package com.skybook.skybook.configuration;
//package com.skybook.skybook.configuration;
//
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@SuppressWarnings("deprecation")
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
//	
//	
//	protected void configure(HttpSecurity http) throws Exception {
//		// TODO Auto-generated method stub
//			
//		
////		super.configure(http);
//		
//	
////		http.csrf().disable();
////		http.httpBasic();
////		
////		http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/1.0/login").authenticated()
////		.and()
////		.authorizeHttpRequests().anyRequest().permitAll();
//		
//		
//	}
//	
//	
//
//}


import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class MySecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
	  
	http.csrf().disable();
	http.httpBasic().authenticationEntryPoint(new BasicAuthenticationEntryPoint());

	http.authorizeHttpRequests().antMatchers(HttpMethod.POST,"/api/1.0/login").authenticated()
		.and()
		.authorizeHttpRequests().anyRequest().permitAll();
	  
	  
//    http.exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
  }
}
