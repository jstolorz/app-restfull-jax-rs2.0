package org.bluesoft.restapp.services.implementations;

import org.bluesoft.restapp.domain.Customer;
import org.junit.*;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class CustomerResourceImplTest {

    private static Client client;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @BeforeClass
    public static void initClient(){
        client = ClientBuilder.newClient();
    }

    @AfterClass
    public static void closeClient(){
        client.close();
    }

    @Test
    public void testCustomerResource() throws Exception{
        try{
            Customer a = client.target("http://localhost:8080/app-rest-orealy-1.0-SNAPSHOT/services/customers/europe-db/1")
                    .request().get(Customer.class);

            System.out.println("...");
        }catch (NotFoundException ex){
            System.out.println("caugh error");
            String error = ex.getResponse().readEntity(String.class);
            System.out.println(error);

        }
    }
}