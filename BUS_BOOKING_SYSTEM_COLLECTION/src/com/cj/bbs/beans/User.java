package com.cj.bbs.beans;


public class User {

	private int userId;
	private String username;
	private String email;
	private String password;
	private long contact;
	
	
	
	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
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



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public long getContact() {
		return contact;
	}



	public void setContact(long contact) {
		this.contact = contact;
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", email=" + email + ", contact=" + contact + "]";
	}
	
	
}