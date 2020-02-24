package com.pipe42.data;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * file IO methods
 */
public class FileWorks implements FileWorksIO {

    @Override
    public File readJsonFile(String filename) {

        return Paths.get("src/data/" + filename).toFile();
    }

    @Override
    public File writeJsonFile(String filename) {
        return null;
    }

}
