package org.bluesoft.restapp.services.intrfaces;

import org.bluesoft.restapp.domain.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface FirstLastCustomerResource {

    @POST
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    Response createCustomer(Customer customer);

    @GET
    @Path("{first}-{last}")
    @Produces(MediaType.APPLICATION_XML)
    Response getCustomer(@PathParam("first") String firstName,
                         @PathParam("last") String lastName,
                         @Context HttpHeaders headers);


    @PUT
    @Path("{first}-{last}")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    Response updateCustomer(@PathParam("first") String firstName,
                            @PathParam("last") String lastName,
                            Customer customer);
}
