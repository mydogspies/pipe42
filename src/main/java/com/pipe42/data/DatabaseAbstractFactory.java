package com.pipe42.data;

/**
 * This is the abstract factory method for various database factories
 *  * A more in-depth explanation of the process can be found under {@com.pipe42.data.DatabaseFactoryProvider}.
 * @author Peter Mankowski
 * @since 0.1.0
 * @see com.pipe42.data.DatabaseJsonFactory
 */
public abstract class DatabaseAbstractFactory {

    /**
     * @see com.pipe42.data.DatabaseIO
     */
    abstract public DatabaseIO getIO();

}
