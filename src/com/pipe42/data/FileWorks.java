package com.pipe42.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Some special file IO methods to fit this project
 * @author Peter Mankowski
 * @since 0.1.0
 */
public class FileWorks {

    private static final Logger log = LoggerFactory.getLogger(FileWorks.class);


    /* GENERAL FILE METHODS */

    /**
     * Writes a text file with an input String with no formatting
     * @param filePathAndName file path and name of type String including extension
     * @param input any input of type String
     * @return true if written, otherwise false
     */
    public Boolean writeTextFile(String filePathAndName, String input) {

        try {

            FileOutputStream outputStream = new FileOutputStream(filePathAndName);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-16");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(input);
            bufferedWriter.close();

            log.debug("writeFileText(): Text written into file: " + filePathAndName);
            return true;

        } catch (IOException e) {
            log.warn("writeFileText(): File IO error: " + filePathAndName);
            e.printStackTrace();
        }

        return false;

    }

    /**
     * When passed an absolute path or a relative local path starting in format "src/.../destination_folder"
     * it will return all files with the specified extension
     * @param path absolute or relative path to source, eg /src/some/path
     * @param extension filter output for files with this specific extension, eg. ".jpg" or ".exe"
     * @return list of file names, otherwise NULL
     */
    public ArrayList<String> getFileNames(String path, String extension) { // TODO add wildcards possibility!!!

        // TODO implement extension!!!

        ArrayList<String> nameArray = new ArrayList<>();

        File folderPath = new File(path);
        File[] fileList = folderPath.listFiles();

        if (fileList.length != 0) {

            for (File file : fileList) {

                if (file.isFile()) {
                    nameArray.add(file.getName());
                }
            }

            log.debug("getFileNames(): Returned a list of files in " + path + " (with extension " + extension +")");
            return nameArray;
        }

        log.warn("getFileNames(): No files with this extension in location or no such location: " + path);
        return null;
    }

    /**
     * Takes a relative path of a folder and writes it to disc
     * example "src/data/myfolder" will write a folder "myfolder" inside the "data" folder
     * @param path relative folder path to be written
     */
    public void writeFolder(String path) { // TODO we are not using this?

        new File(path).mkdirs();
    }


    /* JSON SPECIFIC METHODS */

    /**
     * Reads a file from the disc with either absolute path or relative path from source root.
     * Eg. /src/some/folder/data.json
     * @param filePath path to jason file
     * @return file object, or of not existent then NULL
     */
    public File readFile(String filePath) {

        log.trace("readFile(): incoming path (filePath): " + filePath);

        File file = Paths.get(filePath).toFile();

        if (file.exists()) {

            log.info("readFile(): Returned successfully file " + filePath);
            return file;
        }

        log.warn("readFile(): Failed to read file in path " + filePath + " (Does file or location exist?)");
        return null;
    }

    /**
     * Writes a .json file to the json specific directory
     * @param filename the name of the json file including extension as String
     */
    public void writeJsonFile(String filename) { // TODO not sure we use this - review with every commit

    }

}
