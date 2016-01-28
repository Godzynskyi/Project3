package com.godzynskyi.validate;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class DanceValidation {
    File xsd;
    Validator validator;

    public DanceValidation(File xsd) {
        this.xsd = xsd;

        SchemaFactory schemaFactory = SchemaFactory
                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = null;
        try {
            schema = schemaFactory.newSchema(this.xsd);
        } catch (SAXException e) {
            e.printStackTrace();
        }
        validator = schema.newValidator();
    }

    public static void main(String[] args) {
        File xsd = new File("dance.xsd");
        File xml = new File("Dance.xml");
        DanceValidation danceValidation = new DanceValidation(xsd);
        System.out.println(danceValidation.isValid(xml));
    }

    boolean isValid(File xml) {
        Source xmlFile = new StreamSource(xml);
        try {
            validator.validate(xmlFile);
            System.out.println(xmlFile.getSystemId() + " is valid");
            return true;
        } catch (SAXException e) {
            System.out.println(xmlFile.getSystemId() + " is NOT valid");
            System.out.println("Reason: " + e.getLocalizedMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
