
package com.godzynskyi.entity;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.godzynskyi.entity package.
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    public ObjectFactory() {
    }

    public Dance createDance() {
        return new Dance();
    }

    public Dancers createDancers() {
        return new Dancers();
    }

    public Dance.Performance createDancePerformance() {
        return new Dance.Performance();
    }

    public Person createPerson() {
        return new Person();
    }

    public Dancers.Group createDancersGroup() {
        return new Dancers.Group();
    }

}
