package org.bluesoft.restapp.services;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Path("/row")
public class RowResources {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public StreamingOutput get(){
        return new StreamingOutput() {
            @Override
            public void write(OutputStream output) throws IOException, WebApplicationException {
               output.write("Hello from Row Text.".getBytes());
            }
        };
    }

    @PUT
    @Path("/stuff")
    public Response putStaff(InputStream is){

        String input ="";

        try {
            byte[] bytes = readFromStream(is);
            input = new String(bytes);

        }catch (IOException iex){
            iex.printStackTrace();
        }

        return Response.ok().entity(input).build();
    }

    private byte[] readFromStream(InputStream stream) throws IOException{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] buffer = new byte[1000];
        int wasRead = 0;

        do{

            wasRead = stream.read(buffer);

            if (wasRead > 0){
                baos.write(buffer,0,wasRead);
            }

        }while (wasRead > -1);

        return baos.toByteArray();
    }
}
