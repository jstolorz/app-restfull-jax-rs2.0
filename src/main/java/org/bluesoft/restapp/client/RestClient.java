package org.bluesoft.restapp.client;

import org.bluesoft.restapp.domain.Customer;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestClient {

    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();

        //WebTarget target = client.target("http://localhost:8080/app-rest-orealy-1.0-SNAPSHOT/services/customers/europe-db");

        Customer a = client.target("http://localhost:8080/app-rest-orealy-1.0-SNAPSHOT/services/customers/europe-db/1")
                .request().get(Customer.class);
        //target.request().post(Entity.xml(new Customer("Janusz","Stolorz")));
        System.out.println(a);

        client.close();

    }
}
