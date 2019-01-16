package org.bluesoft.restapp.services;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

@Path("/byte")
public class ByteResources {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public byte[] get(){
        return "Hello from byte array".getBytes();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response post(byte[] bytes){
        String resp = new String(bytes);
        return Response.ok().entity(resp).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_FORM_URLENCODED)
    public MultivaluedMap<String, String> put(MultivaluedMap<String, String> form){
        return form;
    }

}
