package com.pipe42.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Initialize {

    public static ObjectMapper mapper = new ObjectMapper();

    public static void setObjectMapper() {

        mapper.registerModule(new JavaTimeModule());

    }

}
