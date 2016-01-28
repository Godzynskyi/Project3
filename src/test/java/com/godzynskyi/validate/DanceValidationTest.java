package com.godzynskyi.validate;

import junit.framework.TestCase;

import java.io.File;

public class DanceValidationTest extends TestCase {

    public void testIsValid() throws Exception {
        DanceValidation danceValidation = new DanceValidation(new File("dance.xsd"));
        boolean actual = danceValidation.isValid(new File("Dance.xml"));
        assertEquals(true, actual);
    }

    public void testIsNotValid() throws Exception {
        DanceValidation danceValidation = new DanceValidation(new File("dance.xsd"));
        boolean actual = danceValidation.isValid(new File("badDance.xml"));
        assertEquals(false, actual);
    }
}