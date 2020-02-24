package com.pipe42.data;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Xml {

    /**
     * Reads a xml file and returns a raw Document object
     * @param path path to xml file as relative String
     * @return the raw Document object
     */
    public Document readXml(String path) {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(false);
        Document doc = null;

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc  = db.parse(new File(path));
            doc.getDocumentElement().normalize();
            return doc;

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

        return null;
    }

}
