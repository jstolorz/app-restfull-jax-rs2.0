package org.bluesoft.restapp.domain;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "customerxml")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerXML {

    @XmlAttribute
    protected int id;

    @XmlElement
    private String fillName;

    @XmlElement
    private AddressXML addressXML;

    public CustomerXML() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFillName() {
        return fillName;
    }

    public void setFillName(String fillName) {
        this.fillName = fillName;
    }

    public AddressXML getAddressXML() {
        return addressXML;
    }

    public void setAddressXML(AddressXML addressXML) {
        this.addressXML = addressXML;
    }

    @Override
    public String toString() {
        return "CustomerXML{" +
                "id=" + id +
                ", fillName='" + fillName + '\'' +
                ", addressXML=" + addressXML +
                '}';
    }
}
