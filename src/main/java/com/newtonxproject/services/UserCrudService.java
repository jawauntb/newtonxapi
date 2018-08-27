package com.newtonxproject.services;
import com.newtonxproject.beans.User;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/users")
public class UserCrudService {
 
    private Map<Integer, User> userList = new HashMap<Integer, User>();
 
    @GET
    @Path("/getUser")
    @Produces({ MediaType.APPLICATION_JSON})
    public User getUserByUserId(@QueryParam("user_id") Integer user_id) {
        if (userList.containsKey(user_id)) {
            return userList.get(user_id);
        } else {
            return null;
        }
    }
 
    
    @GET
    @Path("/getAllUsers")
    @Produces({ MediaType.APPLICATION_JSON})
    public Map<Integer, User> getAllUsers() {
        Map<Integer, User> userMap = new HashMap<Integer, User>();
       
        if (userList!=null) {
        	for (Integer key: userList.keySet()) {
        		User u = userList.get(key);
        		System.out.println(u.toString());
        		}
        } else {
    			System.out.println("empty list");
            return userMap;
        }
		return userList;
    }
    
    
    @POST
    @Path("/adduser")
    @Consumes({ MediaType.APPLICATION_JSON,})
    public Response addUser(User user) {
        if (null != userList.get(user.getUser_id())) {
            return Response
              .status(Response.Status.NOT_MODIFIED)
              .entity("User is Already in the database.").build();
        }
 
        userList.put(user.getUser_id(), user);
        return Response.status(Response.Status.CREATED).build();
    }
    
    
	@PUT
	@Path("/updateUser")
	@Consumes({ MediaType.APPLICATION_JSON})
	public Response updateUser(User u) {

		System.out.println("*** Calling  updateUser ***");

		if (null == userList.get(u.getUser_id())) {
			return Response.status(Response.Status.NOT_MODIFIED)
					.entity("user is not in the database.\nUnable to Update").build();
		}

		userList.put(u.getUser_id(), u);
		return Response.status(Response.Status.OK).build();
	}

	@DELETE
	@Path("/deleteUser")
	public Response deleteUser(@QueryParam("user _id") Integer user_id) {

		System.out.println("*** Calling  deleteUser ***");

		if (null == userList.get(user_id)) {
			return Response.status(Response.Status.NOT_FOUND).entity("user is not in the database.\nUnable to Delete")
					.build();
		}

		userList.remove(user_id);
		return Response.status(Response.Status.OK).build();
	}

    
}