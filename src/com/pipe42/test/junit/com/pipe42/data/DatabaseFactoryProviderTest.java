package com.pipe42.data;

import org.junit.Test;

import static org.junit.Assert.*;

public class DatabaseFactoryProviderTest {

    @Test
    public void getFactory() {

        DatabaseAbstractFactory daf = DatabaseFactoryProvider.getFactory(DatabaseType.JSON);

        System.out.println("DatabaseFactoryProviderTest: Json info: " + daf.getIO().getDatabaseInfo());

        assertEquals(daf.getIO().getDatabaseInfo(), "Json");

    }
}