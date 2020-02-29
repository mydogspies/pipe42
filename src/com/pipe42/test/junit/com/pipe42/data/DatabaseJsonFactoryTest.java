package com.pipe42.data;

import org.junit.Test;
import static com.pipe42.data.DatabaseType.JSON;

import static org.junit.Assert.*;

public class DatabaseJsonFactoryTest {

    @Test
    public void getIO() {

        DatabaseJsonFactory factory = new DatabaseJsonFactory();

        DatabaseIO io = factory.getIO();

        System.out.println("DatabaseJsonFactoryTest: Json info: " + io.getDatabaseInfo());

        assertEquals(io.getDatabaseInfo(), "Json");

    }
}