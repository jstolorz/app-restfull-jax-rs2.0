package org.bluesoft.restapp.services;

import org.bluesoft.restapp.domain.CustomerJSON;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/json")
public class JsonResources {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response get(){
        CustomerJSON json = new CustomerJSON();
        json.setId(1);
        json.setFirstName("Janusz");
        json.setLastName("Stolorz");

        return Response.ok().entity(json).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(CustomerJSON json){

        return Response.ok().entity(json).build();
    }

}
