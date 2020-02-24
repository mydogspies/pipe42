package com.pipe42.test;

import com.pipe42.data.Xml;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlTest {

    public static void main(String[] args) {

        String url = "src/data/structure.xml";

        Xml xml = new Xml();

        Document doc = xml.readXml(url);

        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        // by "folder"
        NodeList nodeList = doc.getElementsByTagName("folder");

        for (int i=0; i<nodeList.getLength(); i++) {

            Node node = nodeList.item(i);
            System.out.println("Current node: " + node.getNodeName() + " name: " + node.getAttributes().getNamedItem("name"));

        }

        NodeList pnodelist = doc.getDocumentElement().getElementsByTagName("project");
        System.out.println(pnodelist.item(0).getChildNodes().item(0));


        // iterate over project




    }

}
