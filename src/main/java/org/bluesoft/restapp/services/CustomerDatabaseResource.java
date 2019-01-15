package org.bluesoft.restapp.services;

import org.bluesoft.restapp.services.intrfaces.CustomerResource;
import org.bluesoft.restapp.services.intrfaces.FirstLastCustomerResource;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Singleton
@Path("/customers")
public class CustomerDatabaseResource {

    @Inject
    private CustomerResource europe;

    @Inject
    private FirstLastCustomerResource northamerica;

    @Path("{database}-db")
    public Object getDatabase(@PathParam("database") String db){

        if(db.equals("europe")) {
            return europe;
        }else if (db.equals("northamerica")){
            return northamerica;
        }else {
            return null;
        }
    }



}
