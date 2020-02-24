package com.pipe42.data;

import java.io.File;

/**
 * Interface for our file functions
 */
public interface FileWorksIO {

    // common file methods
    File readJsonFile(String filename);
    File writeJsonFile(String filename); // TODO not sure we need this - review every commit

}
