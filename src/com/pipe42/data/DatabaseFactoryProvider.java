package com.pipe42.data;

/**
 * This is the actual provider of factory methods depending on which database we define in our initial setup process.
 * It is usually called from {@com.pipe42.data.DatabaseFactoryProvider} via abstract factory {@com.pipe42.data.DatabaseAbstractFactory}
 * in order to abstract away the particular database specific code from the rest.
 * The public static variable "factory" is defined in the Main method via the initializer {@com.pipe42.main.Initialize}
 * The different database access methods can then be called with Main.factory.method(), independent of the underlying database code.
 * @author Peter Mankowski
 * @since 0.1.0
 * @see com.pipe42.data.DatabaseJson
 * @see com.pipe42.data.DatabaseIO
 * @see com.pipe42.data.DatabaseAbstractFactory
 * @see com.pipe42.main.Main
 * @see com.pipe42.main.Initialize
 */
public class DatabaseFactoryProvider {

    /**
     * This provides us with the right factory method depending on which database we choose.
     * @param type the type of database we want to use
     * @return the specific factory method corresponding to chosen database
     */
    public static DatabaseAbstractFactory getFactory(DatabaseType type) {

        if (DatabaseType.JSON == type) {
            return new DatabaseJsonFactory();
        } else if (DatabaseType.SQLLITE == type) {
            return new DatabaseSQLiteFactory();
        }

        return null;
    }

}
