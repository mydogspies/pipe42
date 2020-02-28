package com.pipe42.data;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * file IO methods
 */
public class FileWorks {

    /**
     * When passed an absolute path or a relative local path starting in format "src/.../destination_folder"
     * it will return all files within that folder as an ArrayList of file names.
     * @param path absolute or relative path to folder as String
     * @return an ArrayList of file names including file extensions
     */
    public ArrayList<String> getFileNames(String path) { // TODO we are not using this?

        ArrayList<String> nameArray = new ArrayList<>();

        File folderPath = new File(path);
        File[] fileList = folderPath.listFiles();

        if (fileList.length != 0) {

            for (File file : fileList) {

                if (file.isFile()) {
                    nameArray.add(file.getName());
                }
            }
        }
        return nameArray;
    }

    /**
     * When passed an absolute path or a relative local path starting in format "src/.../destination_folder"
     * it will return all files with the specified extension, as an ArrayList of file names.
     * @param path absolute or relative path to folder as String
     * @param extension filter output for files with this specific extension in String format
     * @return an ArrayList of file names including file extensions
     */
    public ArrayList<String> getFileNames(String path, String extension) {

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

    /**
     * reads a .json file from the json specific directory
     * @param filename the name of the json file including extension as String
     */
    public File readJsonFile(String filename) {

        return Paths.get("src/data/" + filename).toFile();
    }

    /**
     * Writes a .json file to the json specific directory
     * @param filename the name of the json file including extension as String
     */
    public void writeJsonFile(String filename) { // TODO not sure we use this - review with every commit

    }

}
