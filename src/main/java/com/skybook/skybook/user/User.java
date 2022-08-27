package com.skybook.skybook.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;




// or we can use table anotation @Table(name="users")
@Data 
@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue
	private long id;
	
	// one approach for custom message other than internationalization properties
	@NotNull(message = "Username cannot be a null value")
	@Size(min=4,max=10)
	private String username;
		
	@NotNull
	private String displayName;
	
	
	@NotNull
	@Pattern(regexp="^(?=.{10,}$)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*\\W).*")
	private String password;
	// atlease 10 lenght, 1uper, 1lower, 1 special char, 1 digit
	
	// tell JPA that this will be the primary key
	
// with lombook life is easy
	
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	public String getDisplayName() {
//		return displayName;
//	}
//	public void setDisplayName(String displayName) {
//		this.displayName = displayName;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public User(String username, String displayName, String password) {
//		super();
//		this.username = username;
//		this.displayName = displayName;
//		this.password = password;
//	}
//	
}
