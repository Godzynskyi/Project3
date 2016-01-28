
package com.godzynskyi.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Music.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Music">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="live"/>
 *     &lt;enumeration value="phonogram"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Music", namespace = "http://godzynskyi.com/defaultNameSpaceDance")
@XmlEnum
public enum Music {

    @XmlEnumValue("live")
    LIVE("live"),
    @XmlEnumValue("phonogram")
    PHONOGRAM("phonogram");
    private final String value;

    Music(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Music fromValue(String v) {
        for (Music c: Music.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
