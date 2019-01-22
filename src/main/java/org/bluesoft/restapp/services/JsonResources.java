package org.bluesoft.restapp.services;

import org.bluesoft.restapp.domain.Customer;
import org.bluesoft.restapp.domain.CustomerJSON;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
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

        Response.ResponseBuilder builder = Response.ok(json);
        builder.language("fr")
                .header("Some-Header","some value");



        NewCookie cookie = new NewCookie("key","value");

//        boolean flag = true;
//        if(flag){
//            throw new EntityNotFoundException();
//        }


        return builder.cookie(cookie).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(CustomerJSON json){

        return Response.ok().entity(json).build();
    }

}
