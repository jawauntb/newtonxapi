package com.Beans;

public class User {
	private int user_id;
	private String first_name;
	private String last_name;
	
	public User (String first, String last) {
		this.first_name = first;
		this.last_name = last;
		
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	
	
	
}
