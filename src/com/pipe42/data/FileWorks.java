package com.pipe42.data;

import com.pipe42.prefs.UserPreferences;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * file IO methods
 */
public class FileWorks {


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
            return true;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    /**
     * When passed an absolute path or a relative local path starting in format "src/.../destination_folder"
     * it will return all files with the specified extension, as an ArrayList of file names.
     * @param path absolute or relative path to folder as String
     * @param extension filter output for files with this specific extension in String format
     * @return an ArrayList of file names including file extensions
     */
    public ArrayList<String> getFileNames(String path, String extension) { // TODO add wildcards possibility!!!

        ArrayList<String> nameArray = new ArrayList<>();

        File folderPath = new File(path);
        File[] fileList = folderPath.listFiles();

        if (fileList.length != 0) {

            for (int i = 0; i<fileList.length; i++) {

                if(fileList[i].isFile()) {
                    nameArray.add(fileList[i].getName());
                }
            }
        }

        return nameArray;
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
     * reads a .json file from the json specific directory
     * @param filename the name of the json file including extension as String
     */
    public File readJsonFile(String filename) {

        String filePath = UserPreferences.userSettings.get("databaseJsonRootPath", "") + "/" + filename;

        // return Paths.get("src/data/data.json").toFile(); // TODO remove after bug finding
        return Paths.get(filePath).toFile();
    }

    /**
     * Writes a .json file to the json specific directory
     * @param filename the name of the json file including extension as String
     */
    public void writeJsonFile(String filename) { // TODO not sure we use this - review with every commit

    }

}
