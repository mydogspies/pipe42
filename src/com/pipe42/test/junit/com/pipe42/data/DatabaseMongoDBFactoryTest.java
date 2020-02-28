package com.pipe42.data;

import org.junit.Test;

import static com.pipe42.data.DatabaseType.MONGODB;
import static org.junit.Assert.*;

public class DatabaseMongoDBFactoryTest {

    @Test
    public void getDatabaseInfo() {

        DatabaseMongoDbFactory factory = new DatabaseMongoDbFactory();

        DatabaseIO io = factory.getIO();

        System.out.println("DatabaseMongoDBFactoryTest: mongoDb info: " + io.getDatabaseInfo());

        assertEquals(io.getDatabaseInfo(), "MongoDB");

    }
}