package com.pipe42.data;

/**
 * This is the actual factory method for Json access methods in com.pipe42.data.DatabaseJson.
 * A more in-depth explanation of the process can be found under {@com.pipe42.data.DatabaseFactoryProvider}.
 * @author Peter Mankowski
 * @since 0.1.0
 * @see com.pipe42.data.DatabaseJson
 * @see com.pipe42.data.DatabaseIO
 * @see com.pipe42.data.DatabaseAbstractFactory
 */
public class DatabaseJsonFactory extends DatabaseAbstractFactory {

    /**
     * Returns the set of methods specific to Json as database
     * @return a {@com.pipe42.data.DabaseJson} object
     */
    @Override
    public DatabaseIO getIO() {

        return new DatabaseJson();
    }
}
