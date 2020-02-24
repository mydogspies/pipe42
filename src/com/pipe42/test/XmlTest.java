package com.pipe42.test;

import com.pipe42.data.Xml;
import org.python.antlr.ast.Str;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class XmlTest {

    public static void main(String[] args) {

        String xmlPath = "src/data/structure.xml";
        String writePath = "";

        Xml xml = new Xml();
        Document doc = xml.readXml(xmlPath);


        // by "folder"
        NodeList nodeList = doc.getElementsByTagName("folder");

        // find out how far the structure is nested
        int dp = 0;
        ArrayList<String> pathArray = new ArrayList<String>();
        for(int k=0; k<20; k++){pathArray.add("");} // initiate the array for up to 20 nested folders

        for (int i=0; i<nodeList.getLength(); i++) {

            Node node = nodeList.item(i);

            int depth = Integer.parseInt(node.getAttributes().getNamedItem("depth").getNodeValue());

            String folder = node.getAttributes().getNamedItem("name").getNodeValue();

            pathArray.set(depth, folder);

            writePath = "";
            for(int j=0; j<=depth; j++) {

                writePath += "/" + pathArray.get(j);

            }

            new File("src/com/pipe42/test/folders" + writePath).mkdirs();

            System.out.println(writePath);

        }

    }

}
