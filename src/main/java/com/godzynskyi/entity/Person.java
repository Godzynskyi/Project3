
package com.godzynskyi.entity;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for person complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="person">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="age">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;minInclusive value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="experience">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "person", namespace = "http://godzynskyi.com/dancers", propOrder = {
    "name",
    "age",
    "experience"
})
public class Person {

    @XmlElement(namespace = "http://godzynskyi.com/dancers", required = true)
    protected String name;
    @XmlElement(namespace = "http://godzynskyi.com/dancers", required = true)
    protected int age;
    @XmlElement(namespace = "http://godzynskyi.com/dancers", required = true)
    protected int experience;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the age property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the value of the age property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAge(int value) {
        this.age = value;
    }

    /**
     * Gets the value of the experience property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public int getExperience() {
        return experience;
    }

    /**
     * Sets the value of the experience property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setExperience(int value) {
        this.experience = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Dancer ");
        sb
                .append(name)
                .append(":\r\n")

                .append("Age: ")
                .append(age)

                .append(", experience: ")
                .append(experience)
                .append(";");

        return sb.toString();
    }
}
