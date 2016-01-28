package com.godzynskyi.dom;

import com.godzynskyi.entity.*;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class MyDOMParser {
    private static final String DEFAULT_NAMESPACE = "http://godzynskyi.com/defaultNameSpaceDance";
    private static final String MY_SPACE = "http://godzynskyi.com/dancers";

    public Dance getDance(String filename) {
        Dance result = new Dance();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder=null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        Document document = null;
        try {
            document = builder.parse(new File(filename));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Element root = document.getDocumentElement();
        root.normalize();

        NodeList performanceNodeList = root.getChildNodes();

        for (int i=0; i < performanceNodeList.getLength(); i++) {
            Node performanceNode = performanceNodeList.item(i);
            if (performanceNode.getNodeType() == Node.ELEMENT_NODE) {
                Dance.Performance performance = getPerformance((Element) performanceNode);
                result.getPerformance().add(performance);
            }
        }
        return result;
    }

    private String getAttribute(Element parentNode, String attr) {
        Node attrNode = parentNode.getAttributes().getNamedItem(attr);
        if (attrNode == null) return null;
        return attrNode.getNodeValue();
    }

    private String getTextContent(Element parentNode, String tagName) {
        String textContent = parentNode
                .getElementsByTagNameNS(DEFAULT_NAMESPACE, tagName)
                .item(0)
                .getTextContent();
        return textContent;
    }

    /*private Element getElement(Node parentNode, String tagName) {
        if (parentNode.getNodeType() != Node.ELEMENT_NODE) return null;
        Element parentElement = (Element) parentNode;
        Node node = parentElement.getElementsByTagName(tagName).item(0);

        if (node.getNodeType() != Node.ELEMENT_NODE) return null;
        return (Element) node;
    }*/

    private Dance.Performance getPerformance(Element performanceNode) {
        Dance.Performance result = new Dance.Performance();

        String number = getAttribute(performanceNode, "number");
        result.setNumber(Integer.parseInt(number));

        String title = getAttribute(performanceNode, "title");
        result.setTitle(title);

        String type = getTextContent(performanceNode, "type");
        result.setType(type);

        String scene = getTextContent(performanceNode, "scene");
        result.setScene(Scene.fromValue(scene));

        String numberOfDancers = getTextContent(performanceNode, "numberOfDancers");
        result.setNumberOfDancers(NumberOfDancers.fromValue(numberOfDancers));

        String music = getTextContent(performanceNode, "music");
        result.setMusic(Music.fromValue(music));

        Element dancersElement = (Element) performanceNode.getElementsByTagNameNS(DEFAULT_NAMESPACE, "dancers").item(0);
        Dancers dancers = getDancers(dancersElement);
        result.setDancers(dancers);

        return result;
    }

    private Dancers getDancers(Element dancers) {
        Dancers result = new Dancers();

        NodeList childNodes = dancers.getChildNodes();
        for (int i=0; i<childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            if ("group".equals(node.getLocalName())) {
                result.getPersonOrGroup().add(getGroup((Element) node));
            }
            if ("person".equals(node.getLocalName())) {
                result.getPersonOrGroup().add(getPerson((Element) node));
            }
        }
        return result;
    }

    private Person getPerson(Element personElement) {
        Person result = new Person();

        String name = personElement.getElementsByTagNameNS(MY_SPACE, "name").item(0).getTextContent();
        result.setName(name);

        String age = personElement.getElementsByTagNameNS(MY_SPACE, "age").item(0).getTextContent();
        result.setAge(Integer.parseInt(age));

        String experience = personElement.getElementsByTagNameNS(MY_SPACE, "experience").item(0).getTextContent();
        result.setExperience(Integer.parseInt(experience));

        return result;
    }

    private Dancers.Group getGroup(Element groupElement) {
        Dancers.Group result = new Dancers.Group();
        String name = groupElement.getAttribute("name");
        result.setName(name);

        NodeList persons = groupElement.getElementsByTagNameNS(MY_SPACE, "person");

        for (int i=0; i<persons.getLength(); i++) {
            result.getPerson().add(getPerson((Element) persons.item(0)));
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        MyDOMParser parser = new MyDOMParser();
        Dance dance = parser.getDance("Dance.xml");
        System.out.println(dance);
    }
}
