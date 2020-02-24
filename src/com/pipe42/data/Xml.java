package com.pipe42.data;

import com.pipe42.data.FileWorks;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class to manipulate the file/folder specific xml files
 * @version 0.1a
 */
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

    /**
     * Reads the structure.xml file for a folder tree template, parses file and writes the folder tree to disc
     * @param templateName name of template as String
     */
    public void writeFolderTree(String templateName) {

        // TODO writeLocation and xmlPath needs to move out and into whatever kind of global refs
        String writeLocation = "src/com/pipe42/test/folders"; // TODO this path ONLY for testing
        String xmlPath = "src/data/structure.xml";
        String writePath = "";

        Xml xml = new Xml();
        Document doc = xml.readXml(xmlPath);

        // by "folder"
        NodeList nodeList = doc.getElementsByTagName("folder");

        // the algo
        int dp = 0;
        ArrayList<String> pathArray = new ArrayList<String>();

        // initiate the array for up to 20 nested folders
        for(int k=0; k<20; k++){pathArray.add("");}

        for (int i=0; i<nodeList.getLength(); i++) {

            Node node = nodeList.item(i);

            int depth = Integer.parseInt(node.getAttributes().getNamedItem("depth").getNodeValue());

            String folder = node.getAttributes().getNamedItem("name").getNodeValue();

            pathArray.set(depth, folder);

            writePath = "";
            for (int j = 0; j <= depth; j++) {

                writePath += "/" + pathArray.get(j);

            }

            // write to location
            FileWorks fw = new FileWorks();
            fw.writeFolder(writePath);
        }

    }

}
