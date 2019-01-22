package org.bluesoft.restapp.marshalling;

import org.bluesoft.restapp.annotations.Pretty;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
@Produces(MediaType.APPLICATION_XML)
public class JAXBMarshaller implements MessageBodyWriter {
    @Override
    public boolean isWriteable(Class type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return type.isAnnotationPresent(XmlRootElement.class);
    }

    @Override
    public void writeTo(Object o, Class type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
        try {
            JAXBContext ctx = JAXBContext.newInstance(type);
            Marshaller marshaller = ctx.createMarshaller();

            boolean pretty = false;

            for(Annotation annotation : annotations){
                if (annotation.annotationType().equals(Pretty.class)){
                    pretty = true;
                    break;
                }
            }

            if (pretty){
                marshaller.setProperty(Marshaller.JAXB_FRAGMENT,true);
            }

            marshaller.marshal(o, entityStream);


        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public long getSize(Object o, Class type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }
}
