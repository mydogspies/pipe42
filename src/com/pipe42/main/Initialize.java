package com.pipe42.main;
import com.pipe42.data.DatabaseAbstractFactory;
import com.pipe42.data.DatabaseFactoryProvider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import static com.pipe42.data.DatabaseType.JSON;


/**
 * A number of methods that need to initialize upon start
 */
public class Initialize {

    public static ObjectMapper mapper = new ObjectMapper();

    public static void setObjectMapper() {

        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

    }

    public static DatabaseAbstractFactory DatabaseInitializer() {

        // TODO which database should come from SYSTEM SETTINGS - implement asap!

        return DatabaseFactoryProvider.getFactory(JSON);


    }

}
