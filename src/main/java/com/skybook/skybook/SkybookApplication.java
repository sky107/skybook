package com.skybook.skybook;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


// exclude it otherwise you will get lots of security
@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class SkybookApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkybookApplication.class, args);
	}

}
