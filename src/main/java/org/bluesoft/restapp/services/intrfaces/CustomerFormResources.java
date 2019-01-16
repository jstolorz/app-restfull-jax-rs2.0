package org.bluesoft.restapp.services.intrfaces;


import org.bluesoft.restapp.domain.CustomerInput;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public interface CustomerFormResources {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    Response createCustomer(@BeanParam CustomerInput customer);

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Response getCustomer(@PathParam("id") int id);


    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    Response updateCustomer(@PathParam("id") int id, CustomerInput customer);


}
