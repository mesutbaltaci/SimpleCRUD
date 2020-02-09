package org.ms.entities;

public class User {
	private int users_ID;
	private String username;
	private String email;
	
	
	public User(int users_ID, String username, String email) {
		super();
		this.users_ID = users_ID;
		this.username = username;
		this.email = email;
	}
	
	
	public User(String username, String email) {
		super();
		this.username = username;
		this.email = email;
	}


	public int getUsers_ID() {
		return users_ID;
	}
	public void setUsers_ID(int users_ID) {
		this.users_ID = users_ID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
