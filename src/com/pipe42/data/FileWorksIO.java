package com.pipe42.data;

import java.io.File;

/**
 * Interface for our file functions
 */
public interface FileWorksIO {

    // common file operations
    void writeFolder(String path);

    // common file methods
    File readJsonFile(String filename);
    void writeJsonFile(String filename); // TODO not sure we need this - review every commit



}
