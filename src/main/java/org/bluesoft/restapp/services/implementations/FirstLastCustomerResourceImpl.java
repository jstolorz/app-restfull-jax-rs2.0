package org.bluesoft.restapp.services.implementations;

import org.bluesoft.restapp.domain.Customer;
import org.bluesoft.restapp.services.intrfaces.FirstLastCustomerResource;

import javax.ejb.Singleton;
import javax.ws.rs.core.Response;


public class FirstLastCustomerResourceImpl implements FirstLastCustomerResource {

    @Override
    public Response createCustomer(Customer customer) {
        return null;
    }

    @Override
    public Response getCustomer(String firstName, String lastName) {
        return null;
    }

    @Override
    public Response updateCustomer(String firstName, String lastName, Customer customer) {
        return null;
    }
}
