package com.pipe42.data;

// TODO Branch: develop-factory / this is the factory provider for DatabaseIO interface - once plugged into the main code, take this notice away!

public class DatabaseFactoryProvider {

    public static DatabaseAbstractFactory getFactory(DatabaseType type) {

        if (DatabaseType.JSON == type) {
            return new DatabaseJsonFactory();
        } else if (DatabaseType.MONGODB == type) {
            return new DatabaseMongoDbFactory();
        }

        return null;
    }

}
