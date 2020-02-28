package com.pipe42.data;

// TODO Branch: develop-factory / this is the concrete factory for DatabaseIO interface - once plugged into the main code, take this notice away!

public class DatabaseJsonFactory extends DatabaseAbstractFactory {

    @Override
    public DatabaseIO getIO() {

        return new DatabaseJson();
    }
}
