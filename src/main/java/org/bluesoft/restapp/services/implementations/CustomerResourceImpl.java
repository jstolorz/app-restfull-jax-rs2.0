package org.bluesoft.restapp.services.implementations;

import org.bluesoft.restapp.domain.Customer;
import org.bluesoft.restapp.services.intrfaces.CustomerResource;

import javax.ejb.Stateless;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Stateless
public class CustomerResourceImpl implements CustomerResource {

    private Map<Integer, Customer> customerDB = new ConcurrentHashMap<>();
    private AtomicInteger idCounter = new AtomicInteger();

    public CustomerResourceImpl() {
    }

    public CustomerResourceImpl(Map<Integer, Customer> customerDB) {
        this.customerDB = customerDB;
    }

    public Response createCustomer(Customer customer){

        if(customer == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        customer.setId(idCounter.incrementAndGet());
        customerDB.put(customer.getId(), customer);

        return Response.ok().entity(customer).build();
    }

    public Response getCustomer(@PathParam("id") int id){
        final Customer customer = customerDB.get(id);
        if(customer == null){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        return Response.ok().entity(customer).build();
    }

    public Response updateCustomer(@PathParam("id") int id, Customer customer){
        if(customer == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        Customer cust = customerDB.get(id);

        if(cust == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        cust.setFirstName(customer.getFirstName());
        cust.setLastName(customer.getLastName());
        cust.setCountry(customer.getCountry());
        cust.setZip(customer.getZip());
        cust.setState(customer.getState());
        cust.setCity(customer.getCity());
        cust.setStreet(customer.getStreet());

        return Response.ok().entity(cust).build();
    }


}
