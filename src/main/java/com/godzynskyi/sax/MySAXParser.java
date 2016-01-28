package com.godzynskyi.sax;

import com.godzynskyi.entity.Dance;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class MySAXParser {
    public Dance getDance(File file) throws ParserConfigurationException, SAXException, IOException {
        DanceSAXParser danceSAXParser = new DanceSAXParser();

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        saxParserFactory.setNamespaceAware(true);
        SAXParser saxParser = saxParserFactory.newSAXParser();

        saxParser.parse(file, danceSAXParser);
        return danceSAXParser.getDance();
    }

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        File file = new File("Dance.xml");
        Dance dance = new MySAXParser().getDance(file);
        System.out.println(dance.toString());
    }
}
