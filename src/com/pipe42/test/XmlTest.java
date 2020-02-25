package com.pipe42.test;

import com.pipe42.data.FileWorks;
import com.pipe42.data.Xml;
import com.pipe42.util.Util;
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

       // test getting the template name from the xml template folder
        System.out.println(getXmlTemplateNames());

        // test writing a folder structure to disc
        String template = "this_and_that";
        writeFolderTree(template);

    }

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

    /**
     * Reads a template xml file from the data/templates folder
     * templateName must be the file name WITHOUT the .xml extension
     * NOTE: The parameter "name" in the <project> tag in the template file MUST be the same
     * as the file name (without file extension).
     * @param templateName the template file name as String without file extension
     */
    private static void writeFolderTree(String templateName) {

        String writeLocation = "src/com/pipe42/test/folders";
        String xmlPath = "src/data/templates/" + templateName + ".xml";
        String writePath = "";

        Xml xml = new Xml();
        Document doc = xml.readXml(xmlPath);

        // by "folder"
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

            // new File("src/com/pipe42/test/folders" + writePath).mkdirs();

            System.out.println(writeLocation + writePath);

        }

    }

}
