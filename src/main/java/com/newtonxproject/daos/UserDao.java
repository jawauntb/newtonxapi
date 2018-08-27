package com.newtonxproject.daos;

import com.newtonxproject.beans.User;

public interface UserDao {
	
	public int insert(User u);

	
	public void delete(User u);

	
	public User returnUser(int user_id);
	

}
