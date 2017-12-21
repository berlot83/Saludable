package com.utn.model;

public class User {


	private int id;
	private String user;
	private String password;

	public User(int id, String user, String password) {
		super();
		this.id = id;
		this.user = user;
		this.password = password;
	}
	
	public User(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
