package com.pipe42.data;

import com.pipe42.console.ConsoleOut;
import com.pipe42.prefs.UserPreferences;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * Class to manipulate xml file within our app
 * @author Peter Mankowski
 * @since 0.1.0
 */
public class Xml {

    private static final Logger log = LoggerFactory.getLogger(Xml.class);

    /**
     * Reads a xml file and returns a Document object
     * @param path path to xml file
     * @return the Document object
     */
    public Document readXml(String path) {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(false);
        Document doc = null;

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc  = db.parse(new File(path));
            doc.getDocumentElement().normalize();
            log.info("readXml(): Returned a new Document object based on " + path + ": " + doc);
            return doc;

        } catch (ParserConfigurationException | IOException | SAXException e) {
            log.warn("readXml(): Failed to read or parse the " + path +" file.");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Reads a template xml file from the data/templates folder.
     * templateName must be the file name WITHOUT the .xml extension.
     * NOTE: The parameter "name" in the <project> tag in the template file MUST be the same
     * as the file name (without file extension).
     * @param templateName The template file name as String without file extension.
     */
    public static void writeFolderTree(String templateName, String rootPath, String projectName) {

        // TODO IMPORTANT! Find a way of verifying folder write before program continues and also flag somehow when all is done - Watchlist?

        String xmlPath = UserPreferences.userSettings.get("xmlTemplatePath", "") + "/" + templateName + ".xml";

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
                log.trace("writeFolderTree: " + writePath);

            }

            new File(rootPath + writePath).mkdirs();
        }

        boolean done = writeFolderCheckFile(rootPath, projectName);

        log.info("writeFolderTree(): Wrote a new folder tree into " +  rootPath + " based on template " + templateName);
    }

    /**
     * Write a tiny .pipe42 file into the root of the project folder tree in order
     * to know that this particular folder tree structure is a valid project and what
     * project it belongs to.
     * @param filePathAndName path of type string to the root of the folder tree
     * @param projectName the project name of type String
     * @return true if success, otherwise false
     */
    public static Boolean writeFolderCheckFile(String filePathAndName, String projectName) {

        FileWorks fw = new FileWorks();

        log.debug("writeFolderCheckFile(): Wrote a .pipe42 file into " +filePathAndName);

        return fw.writeTextFile(filePathAndName + "/.pipe42", "project:" + projectName);

    }

    /**
     * Reads all the file names of the xml files in the data/templates folder and returns
     * an array of names minus the file extension ".xml".
     * @return a list of template names
     */
    public static ArrayList<String> getXmlTemplateNames() {

        // test getting all file names in a folder
        FileWorks fw = new FileWorks();
        ArrayList<String> names = fw.getFileNames("src/data/templates", "xml");

        ArrayList<String> truncNames = new ArrayList<>();
        for (String name : names) {
            truncNames.add(name.substring(0, name.lastIndexOf('.')));
        }

        log.debug("getXmlTemplateNames(): Returned a list of template name: " + truncNames);

        return truncNames;
    }

    public static void makeXmlFromFolderTree() {

        // TODO add this method that will make a new xml template file from an existing folder tree structure

    }

}
