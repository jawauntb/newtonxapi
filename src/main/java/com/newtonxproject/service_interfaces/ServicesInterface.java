package com.newtonxproject.service_interfaces;

import com.newtonxproject.beans.User;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

@Path("/users")
public interface ServicesInterface {

    @GET
    @Path("/getUser")
    @Produces({ MediaType.APPLICATION_JSON})
    User getUserByUserId(@QueryParam("user_id") Integer user_id);

    @GET
    @Path("/getAllUsers")
    @Produces({ "application/json" })
    Map<Integer, User> userList();

    @POST
    @Path("/addUser")
    @Consumes({ MediaType.APPLICATION_JSON})
    Response addMovie(User user);

    @PUT
    @Path("/updateUser")
    @Consumes({ MediaType.APPLICATION_JSON})
    Response updateMovie(User user);

    @DELETE
    @Path("/deleteUser")
    Response deleteMovie(@QueryParam("imdbId") String imdbId);

}