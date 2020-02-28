package com.pipe42.data;

// TODO Branch: develop-factory / this is our abstract factory for DatabaseIO - once plugged into the main code, take this notice away!

public abstract class DatabaseAbstractFactory {

    abstract public DatabaseIO getIO();

}
