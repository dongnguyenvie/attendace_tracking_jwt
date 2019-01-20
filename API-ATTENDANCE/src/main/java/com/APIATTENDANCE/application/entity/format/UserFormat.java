package com.APIATTENDANCE.application.entity.format;

import org.springframework.lang.Nullable;

import com.APIATTENDANCE.application.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class UserFormat {
	
	private User user;
	
	private String username;
	private String password;
	public UserFormat() {}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	};
	
}
