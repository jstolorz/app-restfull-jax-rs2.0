package org.bluesoft.restapp.services.implementations;

import org.bluesoft.restapp.domain.CustomerInput;
import org.bluesoft.restapp.services.intrfaces.CustomerFormResources;

import javax.ejb.Stateless;
import javax.ws.rs.core.Response;

@Stateless
public class CustomerFormResourcesImpl implements CustomerFormResources {

    @Override
    public Response createCustomer(CustomerInput customer) {
        return Response.ok().entity(customer).build();
    }

    @Override
    public Response getCustomer(int id) {
        return null;
    }

    @Override
    public Response updateCustomer(int id, CustomerInput customer) {
        return null;
    }
}
