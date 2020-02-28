package com.pipe42.data;

import org.junit.Test;
import org.w3c.dom.Document;

import static org.junit.Assert.*;

public class Xml_readXmlTest {

    @Test
    public void readXml() {

        Xml xml = new Xml();

        Document doc = xml.readXml("src/com/pipe42/test/data/structure.xml");

        System.out.println("Xml_readXmlTest: doc object: " + doc.getElementsByTagName("project"));

        assertNotNull(doc);

    }
}