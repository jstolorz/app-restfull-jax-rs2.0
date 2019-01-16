package org.bluesoft.restapp.services.implementations;

import org.bluesoft.restapp.domain.Customer;
import org.bluesoft.restapp.services.intrfaces.FirstLastCustomerResource;

import javax.ejb.Stateless;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Stateless
public class FirstLastCustomerResourceImpl implements FirstLastCustomerResource {


    private AtomicInteger idCounter = new AtomicInteger();
    private Map<String, Customer> customerDB = new ConcurrentHashMap<>();

    @Override
    public Response createCustomer(Customer customer) {

        if(customer == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        String key = customer.getFirstName() + "-" + customer.getLastName();
        customer.setId(idCounter.incrementAndGet());
        customerDB.put(key, customer);

        return Response.ok().entity(customer).build();
    }

    @Override
    public Response getCustomer(String firstName, String lastName,
                                HttpHeaders headers) {

        String token = headers.getRequestHeader("token").get(0);

        final Customer customer = customerDB.get(firstName + "-" + lastName);

        if (customer == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("We cannot find customer whose name is " + firstName).build();
        }

        return Response.ok().entity(customer + " token " + token).build();
    }

    @Override
    public Response updateCustomer(String firstName, String lastName, Customer customer) {

        Customer current = customerDB.remove(firstName + "-" + lastName);

        if (current == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("We cannot find customer whose name is " + firstName).build();
        }

        current.setFirstName(customer.getFirstName());
        current.setLastName(customer.getLastName());
        current.setStreet(customer.getStreet());
        current.setState(customer.getState());
        current.setZip(customer.getZip());
        current.setCountry(customer.getCountry());

        String key = customer.getFirstName() + "-" + customer.getLastName();
        customerDB.put(key,current);

        return Response.ok().entity(current).build();
    }
}
