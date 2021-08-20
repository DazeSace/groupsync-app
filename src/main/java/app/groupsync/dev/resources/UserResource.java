package app.groupsync.dev.resources;

import app.groupsync.dev.entities.User;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

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
            @FormParam("birthday") String birthday,
            @FormParam("email") String email,
            @FormParam("password") String password
    ) {
        return User.create(firstName, lastName, birthday, email, password);
    }

    @Path("/getById")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public User getById(@FormParam("uuid") String id) {
        return User.findByUuid(id);
    }

    @Path("/getAll")
    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<User> getAllUser() {
        return User.getAll();
    }
}