package app.groupsync.dev.resources;

import app.groupsync.dev.entities.User;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/user")
public class UserResource {

    @Path("/register")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public User register(
            @FormParam("firstName") String firstName,
            @FormParam("lastName") String lastName,
            @FormParam("birthday") String birthday
    ) {
        return User.userAdd(firstName, lastName, birthday);
    }

    @Path("/getById")
    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public User getById( @FormParam("id") String id){
        return User.findByUuid(id);
    }
}