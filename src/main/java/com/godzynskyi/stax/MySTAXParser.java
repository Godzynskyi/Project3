package com.godzynskyi.stax;

import com.godzynskyi.entity.*;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MySTAXParser {
    public Dance getDance(String filename) throws IOException, XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newInstance();

        Path path = Paths.get(filename);
        Reader reader = Files.newBufferedReader(path);

        XMLEventReader eventReader = factory.createXMLEventReader(reader);


        Dance dance = new ObjectFactory().createDance();
        Dance.Performance currentPerformance = null;
        Person currentPerson = null;
        Dancers.Group currentGroup = null;
        boolean isGroup = false;
        Characters characters = null;

        while (eventReader.hasNext()) {

            XMLEvent event = eventReader.nextEvent();

            if (event.getEventType() == XMLEvent.START_ELEMENT) {

                StartElement startElement = event.asStartElement();
                String localName = startElement.getName().getLocalPart();
                switch (localName) {
                    case "performance":
                        currentPerformance = new Dance.Performance();

                        Attribute number = startElement.getAttributeByName(QName.valueOf("number"));
                        currentPerformance.setNumber(Integer.parseInt(number.getValue()));

                        Attribute title = startElement.getAttributeByName(QName.valueOf("title"));
                        if (title != null) currentPerformance.setTitle(title.getValue());

                        dance.getPerformance().add(currentPerformance);
                        break;
                    case "type":
                        event = eventReader.nextEvent();
                        characters = event.asCharacters();
                        currentPerformance.setType(characters.getData());
                        eventReader.nextEvent(); //end
                        eventReader.nextEvent(); //characters
                        break;
                    case "scene":
                        event = eventReader.nextEvent();
                        characters = event.asCharacters();
                        currentPerformance.setScene(Scene.fromValue(characters.getData()));
                        eventReader.nextEvent(); //end
                        eventReader.nextEvent(); //characters
                        break;
                    case "numberOfDancers":
                        event = eventReader.nextEvent();
                        characters = event.asCharacters();
                        currentPerformance.setNumberOfDancers(NumberOfDancers.fromValue(characters.getData()));
                        eventReader.nextEvent(); //end
                        eventReader.nextEvent(); //characters
                        break;
                    case "music":
                        event = eventReader.nextEvent();
                        characters = event.asCharacters();
                        currentPerformance.setMusic(Music.fromValue(characters.getData()));
                        eventReader.nextEvent(); //end
                        eventReader.nextEvent(); //characters
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
                        event = eventReader.nextEvent();
                        characters = event.asCharacters();
                        currentPerson.setName(characters.getData());
                        break;
                    case "age":
                        event = eventReader.nextEvent();
                        characters = event.asCharacters();
                        currentPerson.setAge(Integer.parseInt(characters.getData()));
                        break;
                    case "experience":
                        event = eventReader.nextEvent();
                        characters = event.asCharacters();
                        currentPerson.setExperience(Integer.parseInt(characters.getData()));
                        break;
                    case "group":
                        currentGroup = new Dancers.Group();
                        Attribute name = startElement.getAttributeByName(QName.valueOf("name"));
                        currentGroup.setName(name.getValue());
                        currentPerformance.getDancers().getPersonOrGroup().add(currentGroup);
                        isGroup = true;
                        break;
                }
            }

            if (event.getEventType() == XMLEvent.END_ELEMENT) {
                EndElement endElement = event.asEndElement();
                String localPart = endElement.getName().getLocalPart();
                if (localPart.equals("group")) {
                    isGroup = false;
                }
            }
        }
        return dance;
    }

    public static void main(String[] args) throws IOException, XMLStreamException {
        MySTAXParser mySTAXParser = new MySTAXParser();
        Dance dance = mySTAXParser.getDance("Dance.xml");
        System.out.println(dance);
    }
}
