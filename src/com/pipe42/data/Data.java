package com.pipe42.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class Data {

    private List<Object> database;

    /* CONSTRUCTORS */

    public Data() {}

    public Data(List<Object> database) {

        this.database = database;
    }

    /* GETTERS AND SETTERS */

    public List<Object> getDatabase() {

        return database;
    }

    public void setDatabase(List<Object> database) {

        this.database = database;
    }

}
