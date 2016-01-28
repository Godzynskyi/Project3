package com.godzynskyi.entity;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="performance" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="scene" type="{http://godzynskyi.com/defaultNameSpaceDance}Scene"/>
 *                   &lt;element name="numberOfDancers" type="{http://godzynskyi.com/defaultNameSpaceDance}NumberOfDancers"/>
 *                   &lt;element name="music" type="{http://godzynskyi.com/defaultNameSpaceDance}Music"/>
 *                   &lt;element name="dancers" type="{http://godzynskyi.com/dancers}dancers"/>
 *                 &lt;/all>
 *                 &lt;attribute name="number" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                 &lt;attribute name="title" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "performance"
})
@XmlRootElement(name = "dance", namespace = "http://godzynskyi.com/defaultNameSpaceDance")
public class Dance {

    @XmlElement(namespace = "http://godzynskyi.com/defaultNameSpaceDance", required = true)
    protected List<Dance.Performance> performance = new ArrayList<>();

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class Performance {

        @XmlElement(namespace = "http://godzynskyi.com/defaultNameSpaceDance", required = true)
        protected String type;
        @XmlElement(namespace = "http://godzynskyi.com/defaultNameSpaceDance", required = true)
        @XmlSchemaType(name = "string")
        protected Scene scene;
        @XmlElement(namespace = "http://godzynskyi.com/defaultNameSpaceDance", required = true)
        @XmlSchemaType(name = "string")
        protected NumberOfDancers numberOfDancers;
        @XmlElement(namespace = "http://godzynskyi.com/defaultNameSpaceDance", required = true)
        @XmlSchemaType(name = "string")
        protected Music music;
        @XmlElement(namespace = "http://godzynskyi.com/defaultNameSpaceDance", required = true)
        protected Dancers dancers;
        @XmlAttribute(name = "number", required = true)
        protected int number;
        @XmlAttribute(name = "title")
        protected String title;

        public String getType() {
            return type;
        }

        public void setType(String value) {
            this.type = value;
        }

        public Scene getScene() {
            return scene;
        }

        public void setScene(Scene value) {
            this.scene = value;
        }

        public NumberOfDancers getNumberOfDancers() {
            return numberOfDancers;
        }

        public void setNumberOfDancers(NumberOfDancers value) {
            this.numberOfDancers = value;
        }

        public Music getMusic() {
            return music;
        }

        public void setMusic(Music value) {
            this.music = value;
        }

        public Dancers getDancers() {
            return dancers;
        }

        public void setDancers(Dancers value) {
            this.dancers = value;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int value) {
            this.number = value;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String value) {
            this.title = value;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Performance ")
                    .append(number);
            if (title != null) {
                sb
                        .append(" (")
                        .append(title)
                        .append(")");
            }
            sb
                    .append(":\r\n  Type: ")
                    .append(type)
                    .append(",\r\n  ")

                    .append("Scene: ")
                    .append(scene.value())
                    .append(",\r\n  ")

                    .append("Quantity of dancers: ")
                    .append(numberOfDancers.value())
                    .append(",\r\n  ")

                    .append("Music: ")
                    .append(music.value())
                    .append(",\r\n  ")

                    .append(dancers.toString());
            return sb.toString();
        }
    }

    public List<Dance.Performance> getPerformance() {
        return this.performance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DANCE:\r\n");
        for (Dance.Performance p : performance) {
            sb.append(p.toString())
                    .append("\r\n");
        }
        return sb.toString();
    }

}
