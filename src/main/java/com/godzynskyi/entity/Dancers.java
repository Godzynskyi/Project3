
package com.godzynskyi.entity;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dancers complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dancers">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded">
 *           &lt;element name="person" type="{http://godzynskyi.com/dancers}person"/>
 *           &lt;element name="group">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="person" type="{http://godzynskyi.com/dancers}person" maxOccurs="unbounded"/>
 *                   &lt;/sequence>
 *                   &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dancers", namespace = "http://godzynskyi.com/dancers", propOrder = {
    "personOrGroup"
})
public class Dancers {

    @XmlElements({
        @XmlElement(name = "person", namespace = "http://godzynskyi.com/dancers", type = Person.class),
        @XmlElement(name = "group", namespace = "http://godzynskyi.com/dancers", type = Dancers.Group.class)
    })
    protected List<Object> personOrGroup = new ArrayList<>();

    public List<Object> getPersonOrGroup() {
        return this.personOrGroup;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "person"
    })
    public static class Group {

        @XmlElement(namespace = "http://godzynskyi.com/dancers", required = true)
        protected List<Person> person = new ArrayList<>();
        @XmlAttribute(name = "name", required = true)
        protected String name;

        public List<Person> getPerson() {
            return this.person;
        }

        public String getName() {
            return name;
        }

        public void setName(String value) {
            this.name = value;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("Group ");
            sb
                    .append(name)
                    .append(":\r\n");
            for (Person p: person) {
                sb.append(p.toString())
                        .append("\r\n");
            }
            return sb.toString();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Dancers:\r\n");
        for (Object o: personOrGroup) {
            sb.append(o.toString())
                    .append("\r\n\r\n");
        }
        return sb.toString();
    }
}
