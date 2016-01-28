package com.godzynskyi.transformer;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XSLTransformer {
    public static void main(String[] args) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new File("dance.xsl"));
        Transformer transformer = factory.newTransformer(xslt);

        Source text = new StreamSource(new File("Dance.xml"));
        transformer.transform(text, new StreamResult(new File("dance.html")));
    }
}
