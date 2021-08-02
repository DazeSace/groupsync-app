package app.groupsync.dev.resources;

import app.groupsync.dev.entities.Offer;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/offer")
public class OfferResource {

    @Path("/create")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Offer createOffer(
            @FormParam("offerer") String offerer,
            @FormParam("name") String name,
            @FormParam("capacity") int capacity,
            @FormParam("price") float price,
            @FormParam("length") float length,
            @FormParam("location") String location

    ) {
        return Offer.create(offerer, name, capacity, price, length, location);
    }

    @Path("/getById")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Offer getById(@FormParam("uuid") String uuid) {
        return Offer.findByUuid(uuid);
    }

    @Path("/getAll")
    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<Offer> getAllOffer() {
        return Offer.getAll();
    }
}