package com.pipe42.data;

public class DatabaseSQLiteFactory extends DatabaseAbstractFactory {

    @Override
    public DatabaseIO getIO() {

        return new DatabaseSQLite();
    }
}
