package com.newtonxproject; 

import com.newtonxproject.beans.User;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UserList {
    private Set<User> UserList = new HashSet<User>();
   
    private int user_count = 0; 
	
    private static UserList mainlist = null;
   
    private UserList()
    {
    	User mockuser = new User("blank", "user", 0);
    	addUser(mockuser);
    }
 
    // static method to create instance of userlist class
    public static UserList getUserList()
    {
        if (mainlist == null)
        		mainlist = new UserList();
        return mainlist;
    }
    
    public String addUser (User u) {
	    this.UserList.add(u);
	    	String userdata = u.getFirst_name() + u.getLast_name();
	    	return ("UsersList added" + userdata);
    }
    
    public getUser_by_id(int id) {
    		
    	}
 
    
    public get_all_users() {
    	
    	
    }
}
