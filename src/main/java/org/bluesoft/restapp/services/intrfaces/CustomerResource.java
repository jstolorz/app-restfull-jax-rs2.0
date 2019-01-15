package org.bluesoft.restapp.services.intrfaces;

import org.bluesoft.restapp.domain.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface CustomerResource {

    @POST
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    Response createCustomer(Customer customer);

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    Response getCustomer(@PathParam("id") int id);


    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    Response updateCustomer(@PathParam("id") int id, Customer customer);


}
