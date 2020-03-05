package com.pipe42.data.pojos;

import com.fasterxml.jackson.core.type.TypeReference;
import com.pipe42.main.Initialize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class contains methods for parsing POJOs using the Java Reflection and Jackson
 * @author Peter Mankowski
 * @since 0.2.0
 */
public class PojoParser {

    private static final Logger log = LoggerFactory.getLogger(PojoParser.class);

    /**
     * Converts a pojo into a map using Jackson.
     * @param pojo pojo object
     * @return Map of key/value pairs. If map is empty then null.
     */
    public static Map<String, String> parsePojoToMap (Object pojo) {

        Map<String, String> map = Initialize.mapper.convertValue(pojo, new TypeReference<Map<String, String>>() {});

        log.debug("parsePojoMap(): Returned a map of values from pojo (" + pojo + "): " + map);

        if (!map.isEmpty()) {
            return map;
        } else {
            log.warn("parsePojoMap(): Pojo (" + pojo + ") returned not map.");
            return null;
        }

    }

    /**
     * Takes any class object and returns the fields as a list.
     * Note that index [0] always contains the name of the class the object belongs too.
     *
     * @param pojo POJO or any class object
     * @return list of fields with the index[0] containing the class name
     */
    public static List<String> parsePojoFieldsAndClass(Object pojo) {

        // get the class, read the fields and put all in a List
        //
        ArrayList<String> fieldList = new ArrayList<>();

        // add the class name
        fieldList.add(pojo.getClass().getSimpleName());

        Field[] fieldsInPojo = pojo.getClass().getDeclaredFields();
        for (Field field : fieldsInPojo) {
            fieldList.add(field.getName());
        }

        if (!fieldList.isEmpty()) {
            log.debug("parsePojoFieldsAndClass(): Parsed object (" + pojo + ") and returned a list: " + fieldList);
        } else {
            log.warn("parsePojoFieldsAndClass(): Object (" + pojo + ") and returned an empty list.");
            return null;
        }

        return fieldList;
    }
}
