package com.pipe42.data;

import com.pipe42.console.ConsoleOut;
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
     * Reads a template xml file from the data/templates folder
     * templateName must be the file name WITHOUT the .xml extension
     * NOTE: The parameter "name" in the <project> tag in the template file MUST be the same
     * as the file name (without file extension).
     * @param templateName the template file name as String without file extension
     */
    private static void writeFolderTree(String templateName) {

        String writeLocation = "src/com/pipe42/test/folders"; // TODO this variable has to move to USER PREFS
        String xmlPath = "src/data/templates/" + templateName + ".xml"; // TODO this variable has to move to SYSTEM VARS
        String writePath = "";

        Xml xml = new Xml();
        Document doc = xml.readXml(xmlPath);
        NodeList nodeList = doc.getElementsByTagName("folder");

        // find out how far the structure is nested
        int dp = 0;
        ArrayList<String> pathArray = new ArrayList<String>();
        for (int k = 0; k < 20; k++) {
            pathArray.add("");
        } // initiate the array for up to 20 nested folders

        for (int i = 0; i < nodeList.getLength(); i++) {

            Node node = nodeList.item(i);

            int depth = Integer.parseInt(node.getAttributes().getNamedItem("depth").getNodeValue());

            String folder = node.getAttributes().getNamedItem("name").getNodeValue();

            pathArray.set(depth, folder);

            writePath = "";
            for (int j = 0; j <= depth; j++) {

                writePath += "/" + pathArray.get(j);

            }

            new File(writeLocation + writePath).mkdirs();
            ConsoleOut.printCons("New folder structure written to " + writeLocation);
        }

    }

    /**
     * Reads all the file names of the xml files in the data/templates folder and returns
     * an array of names minus the file extension ".xml".
     * @return an ArrayList of template names of type String
     */
    private static ArrayList<String> getXmlTemplateNames() {

        // test getting all file names in a folder
        FileWorks fw = new FileWorks();
        ArrayList<String> names = fw.getFileNames("src/data/templates", "xml");

        ArrayList<String> truncNames = new ArrayList<>();
        for (String name : names) {
            truncNames.add(name.substring(0, name.lastIndexOf('.')));
        }

        return truncNames;
    }

}
