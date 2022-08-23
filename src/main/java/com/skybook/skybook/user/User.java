package com.skybook.skybook.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;




// or we can use table anotation @Table(name="users")
@Data 
@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue
	private long id;
	private String username;
	private String displayName;
	private String password;
	
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
