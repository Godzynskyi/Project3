package com.godzynskyi.sax;

import com.godzynskyi.entity.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class DanceSAXParser extends DefaultHandler {

    Dance dance = new ObjectFactory().createDance();

    Stack<StartElementInformation> elements = new Stack<>();

    static class StartElementInformation {
        String uri;
        String localName;
        String qName;
        Attributes attributes;

        public StartElementInformation(String uri, String localName, String qName, Attributes attributes) {
            this.uri = uri;
            this.localName = localName;
            this.qName = qName;
            this.attributes = attributes;
        }
    }

    Dance.Performance currentPerformance;
    Person currentPerson;
    Dancers.Group currentGroup;
    boolean isGroup = false;
    boolean endElement = false;




    public Dance getDance() {
        return dance;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        StartElementInformation startElementInformation = new StartElementInformation(uri, localName, qName, attributes);
        elements.push(startElementInformation);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        StartElementInformation currentElement = elements.peek();
        if (endElement) {
            endElement = false;
            return;
        }

        switch (currentElement.localName) {
            case "dance":
                break;
            case "performance":
                currentPerformance = new Dance.Performance();
                currentPerformance.setNumber(Integer.parseInt(currentElement.attributes.getValue("number")));
                currentPerformance.setTitle(currentElement.attributes.getValue("title"));
                dance.getPerformance().add(currentPerformance);
                break;
            case "type":
                currentPerformance.setType(new String(ch, start, length));
                break;
            case "scene":
                currentPerformance.setScene(Scene.fromValue(new String(ch, start, length)));
                break;
            case "numberOfDancers":
                currentPerformance.setNumberOfDancers(NumberOfDancers.fromValue(new String(ch, start, length)));
                break;
            case "music":
                currentPerformance.setMusic(Music.fromValue(new String(ch, start, length)));
                break;
            case "dancers":
                currentPerformance.setDancers(new Dancers());
                break;
            case "person":
                currentPerson = new Person();
                if (!isGroup) {
                    currentPerformance.getDancers().getPersonOrGroup().add(currentPerson);
                } else {
                    currentGroup.getPerson().add(currentPerson);
                }
                break;
            case "name":
                currentPerson.setName(new String(ch, start, length));
                break;
            case "age":
                currentPerson.setAge(Integer.parseInt(new String(ch, start, length)));
                break;
            case "experience":
                currentPerson.setExperience(Integer.parseInt(new String(ch, start, length)));
                break;
            case "group":
                currentGroup = new Dancers.Group();
                String name = currentElement.attributes.getValue("name");
                currentGroup.setName(name);
                currentPerformance.getDancers().getPersonOrGroup().add(currentGroup);
                isGroup = true;
                break;

        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        elements.pop();
        endElement = true;
        if (localName.equals("group")) isGroup = false;
    }
}
