package org.bluesoft.restapp.jaxbtest;

import org.bluesoft.restapp.domain.CustomerXML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.StringReader;
import java.io.StringWriter;

public class Test {

    public static void main(String[] args) throws JAXBException {

        CustomerXML customerXML = new CustomerXML();
        customerXML.setId(45);
        customerXML.setFillName("Janusz Stolorz");

        JAXBContext ctx = JAXBContext.newInstance(CustomerXML.class);
        StringWriter writer = new StringWriter();

        ctx.createMarshaller().marshal(customerXML,writer);
        String cust = writer.toString();

        System.out.println(cust);

        CustomerXML xml = (CustomerXML) ctx.createUnmarshaller()
                              .unmarshal(new StringReader(cust));

        System.out.println(xml);


    }
}
