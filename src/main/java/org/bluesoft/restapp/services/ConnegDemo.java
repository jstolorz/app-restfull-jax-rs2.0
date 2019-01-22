package org.bluesoft.restapp.services;


import org.bluesoft.restapp.domain.Customer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/conneg")
public class ConnegDemo {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getXML(@Context HttpHeaders headers){

        Customer customer = new Customer("Janusz","XML");

        return Response.ok().entity(customer).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJSON(){
        Customer customer = new Customer("Janusz","JSON");

        return Response.ok().entity(customer).build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getTEXT(){
        Customer customer = new Customer("Janusz","TEXT");

        return Response.ok().entity(customer).build();
    }

//    @GET
//    Response getSomething(@Context Request request) {
//        List<Variant> variants = new ArrayList<Variant>();
//        variants.add(new Variant(
//                MediaType.APPLICATION_XML_TYPE,
//                "en", "deflate"));
//        variants.add(new Variant(
//                MediaType.APPLICATION_XML_TYPE,
//                "es", "deflate"));
//        variants.add(new Variant(
//                MediaType.APPLICATION_JSON_TYPE,
//                "en", "deflate"));
//        variants.add(new Variant(
//                MediaType.APPLICATION_JSON_TYPE,
//                "es", "deflate"));
//        variants.add(new Variant(
//                MediaType.APPLICATION_XML_TYPE,
//                "en", "gzip"));
//        variants.add(new Variant(
//                MediaType.APPLICATION_XML_TYPE,
//                "es", "gzip"));
//        variants.add(new Variant(
//                MediaType.APPLICATION_JSON_TYPE,
//                "en", "gzip"));
//        variants.add(new Variant(
//                MediaType.APPLICATION_JSON_TYPE,
//                "es", "gzip"));
//// Pick the variant
//        Variant v = request.selectVariant(variants);
//        Customer customer = new Customer("Janusz","Stolorz");
//        Response.ResponseBuilder builder = Response.ok(customer);
//
//        builder.type(v.getMediaType())
//                .language(v.getLanguage())
//                .header("Content-Encoding", v.getEncoding());
//
//        return builder.build();
//    }

}
