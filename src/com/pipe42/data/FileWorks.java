package com.pipe42.data;

import java.io.File;
import java.nio.file.Paths;

/**
 * file IO methods
 */
public class FileWorks implements FileWorksIO {


    /**
     * Takes a relative path of a folder and writes it to disc
     * example "src/data/myfolder" will write a folder "myfolder" inside the "data" folder
     * @param path relative folder path to be written
     */
    @Override
    public void writeFolder(String path) {

        new File(path).mkdirs();
    }

    /**
     * reads a .json file from the json specific directory
     * @param filename the name of the json file including extension as String
     */
    @Override
    public File readJsonFile(String filename) {

        return Paths.get("src/data/" + filename).toFile();
    }

    /**
     * Writes a .json file to the json specific directory
     * @param filename the name of the json file including extension as String
     */
    @Override
    public void writeJsonFile(String filename) { // TODO not sure we use this - review with every commit

    }

}
