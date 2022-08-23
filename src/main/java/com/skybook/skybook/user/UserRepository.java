package com.skybook.skybook.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
 
	// no need to user anootaionts
	// spring will create a proxy implemnation automatically
	// automaticall  look which extends Jpa
	
}
