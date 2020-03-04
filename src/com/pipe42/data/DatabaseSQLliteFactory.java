package com.pipe42.data;

public class DatabaseSQLliteFactory extends DatabaseAbstractFactory {

    @Override
    public DatabaseIO getIO() {

        return new DatabaseSQLlite();
    }
}
