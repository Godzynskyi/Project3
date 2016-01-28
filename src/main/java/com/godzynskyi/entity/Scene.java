
package com.godzynskyi.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Scene.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Scene">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="big"/>
 *     &lt;enumeration value="small"/>
 *     &lt;enumeration value="hall"/>
 *     &lt;enumeration value="open air"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Scene", namespace = "http://godzynskyi.com/defaultNameSpaceDance")
@XmlEnum
public enum Scene {

    @XmlEnumValue("big")
    BIG("big"),
    @XmlEnumValue("small")
    SMALL("small"),
    @XmlEnumValue("hall")
    HALL("hall"),
    @XmlEnumValue("open air")
    OPEN_AIR("open air");
    private final String value;

    Scene(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Scene fromValue(String v) {
        for (Scene c: Scene.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
