package com.pipe42.data;

// TODO Branch: develop-factory / this is the factory for MongoDB - once plugged into the main code, take this notice away!

public class DatabaseMongoDbFactory extends DatabaseAbstractFactory {

    @Override
    public DatabaseIO getIO() {

        return new DatabaseMongoDB();
    }
}
