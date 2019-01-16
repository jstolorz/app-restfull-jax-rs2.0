package org.bluesoft.restapp.domain;

import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;

public class CustomerInput {

    @FormParam("first")
    private String firstName;

    @FormParam("last")
    private String lastName;

    @HeaderParam("Content-Type")
    private String contentType;

    public CustomerInput() {
    }

    public CustomerInput(String firstName, String lastName, String contentType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contentType = contentType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String toString() {
        return "CustomerInput{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contentType='" + contentType + '\'' +
                '}';
    }
}
