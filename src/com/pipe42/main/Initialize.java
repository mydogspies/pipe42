package com.pipe42.main;
import ch.qos.logback.classic.Level;
import com.pipe42.data.DatabaseAbstractFactory;
import com.pipe42.data.DatabaseFactoryProvider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.pipe42.prefs.UserPreferences;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.pipe42.data.DatabaseType.JSON;
import static com.pipe42.data.DatabaseType.SQLITE;


/**
 * A number of methods that need to initialize upon start
 */
public class Initialize {

    private static final Logger log = LoggerFactory.getLogger(Initialize.class);
    public static ObjectMapper mapper = new ObjectMapper();

    public static void setObjectMapper() {

        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

    }

    /**
     * Looks up user preferences and returns the right factory for the current database
     * @return returns the database specific factory
     */
    public static DatabaseAbstractFactory databaseInitializer() {

        if (UserPreferences.getPrefs().get("database", "").equals("json")) {
            log.info("databaseInitializer(): json database loaded");
            return DatabaseFactoryProvider.getFactory(JSON);
        } else if (UserPreferences.getPrefs().get("database", "").equals("sqlite")){
            log.info("databaseInitializer(): SQlite database loaded");
            return DatabaseFactoryProvider.getFactory(SQLITE);
        } else {
            log.error("databaseInitializer(): no database returned from UserPreferences");
            return null;
        }

    }

    /**
     * Sets the reporting level of Logback
     * @param level the level
     * @since 0.2.0
     * @see <a href="http://logback.qos.ch/">Logback</a>
     */
    public static void logReportLevel(String level) {

        ch.qos.logback.classic.Logger rootLogger = (ch.qos.logback.classic.Logger)LoggerFactory.getLogger(ch.qos.logback.classic.Logger.ROOT_LOGGER_NAME);
        rootLogger.setLevel(Level.toLevel(level));

    }

}
