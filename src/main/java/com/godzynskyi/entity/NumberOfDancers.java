
package com.godzynskyi.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NumberOfDancers.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NumberOfDancers">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="solo"/>
 *     &lt;enumeration value="pair"/>
 *     &lt;enumeration value="group"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "NumberOfDancers", namespace = "http://godzynskyi.com/defaultNameSpaceDance")
@XmlEnum
public enum NumberOfDancers {

    @XmlEnumValue("solo")
    SOLO("solo"),
    @XmlEnumValue("pair")
    PAIR("pair"),
    @XmlEnumValue("group")
    GROUP("group");
    private final String value;

    NumberOfDancers(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static NumberOfDancers fromValue(String v) {
        for (NumberOfDancers c: NumberOfDancers.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
