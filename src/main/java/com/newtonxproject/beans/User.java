package com.newtonxproject.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="User")
public class User {
	//data members
	@Id
	@Column(name = "user_id")
	@SequenceGenerator(sequenceName="USER_SEQ", name="USER_SEQ")
	@GeneratedValue(generator="USER_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer user_id = 0;
	
	@Column(name="first_name")
	private String first_name = "";
	
	@Column(name="last_name")
	private String last_name = "";
	
	@Column(name="whole_name")
	private String whole_name = ""; 

	//complete constructor
	public User (String first, String last, Integer user_id) {
		super();
		this.first_name = first;
		this.last_name = last;
		this.user_id = user_id;
	}

	//constructor that will be used most often	
	public User (String first, String last) {
		super();
		this.first_name = first;
		this.last_name = last;
	}
	
	//blank constructor for empty object
	public User () {		
		super();
	}
	
	//getter for user id
	public Integer getUser_id() {return user_id;}

	//setter for user id
	public void setUser_id(Integer user_id) {this.user_id = user_id;}

	//getter for user first name
	public String getFirst_name() {return first_name;}
	
	//setter for user first name
	public void setFirst_name(String first_name) {this.first_name = first_name;}

	//getter for user last name
	public String getLast_name() {return last_name;}

	//setter for user last name
	public void setLast_name(String last_name) {this.last_name = last_name;}
	
	//whole name getter and setter for returning whole name as one string
	public String getWhole_name() {return whole_name;}
	
	//setter for returning whole name as one string
	public void setWhole_name(String whole_name) {this.whole_name = this.first_name + " " + this.last_name;}

//over-riding toString to make json-ish object string
	@Override
	public String toString() {
		return "User{" +
				"user_id='" + getUser_id() + '\'' +
				", first_name='" + getFirst_name() + '\'' +
				", last_name='" + getLast_name() + '\'' +
				", whole_name='" + getWhole_name() + '\'' +
				'}';
	}
//end file	
}
