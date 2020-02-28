package com.pipe42.util;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class UtilTest {

    @Test
    public void getDateTime() {

        HashMap<String, String> date = Util.getDateTime();

        System.out.println("UtilTest/getDateTime: date: " + date.get("date"));

        assertNotNull(date);
    }

    @Test
    public void getHash() {

        String hash = Util.getHash("salt");

        System.out.println("Util/getHash: hash: " + hash);

        assertNotNull(hash);
    }
}