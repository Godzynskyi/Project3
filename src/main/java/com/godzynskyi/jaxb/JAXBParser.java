package com.godzynskyi.jaxb;

import com.godzynskyi.entity.Dance;
import com.godzynskyi.entity.Music;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXBParser {

    public Dance getDance(String fileName) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance("com.godzynskyi.entity");

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File file = new File(fileName);
        Dance dance = (Dance) unmarshaller.unmarshal(file);
        return dance;
    }

    public void printXml(Dance dance) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance("com.godzynskyi.entity");

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(dance, System.out);
    }


    public static void main(String[] args) throws JAXBException {
        JAXBParser parser = new JAXBParser();
        Dance dance = parser.getDance("Dance.xml");
        dance.getPerformance().get(0).setMusic(Music.LIVE);
        parser.printXml(dance);

    }

}
