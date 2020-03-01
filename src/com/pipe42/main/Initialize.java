package com.pipe42.main;
import com.pipe42.data.DatabaseAbstractFactory;
import com.pipe42.data.DatabaseFactoryProvider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.pipe42.prefs.UserPreferences;

import static com.pipe42.data.DatabaseType.JSON;
import static com.pipe42.data.DatabaseType.MONGODB;


/**
 * A number of methods that need to initialize upon start
 */
public class Initialize {

    public static ObjectMapper mapper = new ObjectMapper();

    public static void setObjectMapper() {

        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

    }

    /**
     * Looks up user preferences and returns the right factory for the current database
     * @return returns the database specific factory
     */
    public static DatabaseAbstractFactory DatabaseInitializer() {

        if (UserPreferences.getPrefs().get("database", "json").equals("json")) {
            return DatabaseFactoryProvider.getFactory(JSON);
        } else {
            return DatabaseFactoryProvider.getFactory(MONGODB);
        }

    }

}
