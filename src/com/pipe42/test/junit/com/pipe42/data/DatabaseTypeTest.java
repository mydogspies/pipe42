package com.pipe42.data;

import org.junit.Test;

import static org.junit.Assert.*;

public class DatabaseTypeTest {

    @Test
    public void DatabaseTypeTest() {

        DatabaseType type = DatabaseType.JSON;
        System.out.println("Enum set as value: " + type);
        assertEquals(DatabaseType.valueOf("JSON"), type);

        DatabaseType type2 = DatabaseType.JSON;
        System.out.println("Enum set as value: " + type2);
        assertEquals(DatabaseType.valueOf("JSON"), type2);

    }

}